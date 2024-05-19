package com.denisfominykh.messengeruser.service.serviceimpl

import com.denisfominykh.messengeruser.exception.UserAlreadyExistsException
import com.denisfominykh.messengeruser.region.Region
import com.denisfominykh.messengeruser.result.LoginResult
import com.denisfominykh.messengeruser.result.TokenExchangeResult
import com.denisfominykh.messengeruser.service.UserService
import com.denisfominykh.messengeruser.service.UserStorageService
import com.denisfominykh.messengeruser.user.User
import com.denisfominykh.messengeruser.tool.UserToken
import org.springframework.stereotype.Service
import java.security.MessageDigest
import java.time.Instant
import java.util.concurrent.ThreadLocalRandom

@Service
class UserServiceImpl(
    private val storageService: UserStorageService,
    private val md5MessageDigest: MessageDigest,
) : UserService {
    override fun registerUser(
        username: String,
        region: Region,
        hashedPassword: String,
    ): User {
        if (storageService.existsByUsername(username)) {
            throw UserAlreadyExistsException(username)
        }

        val id = storageService.findLastId().inc()
        return storageService.save(User(id, username, region, hashedPassword, null))
    }

    override fun attemptLogin(
        userName: String,
        hashedPassword: String,
    ): LoginResult {
        val user = storageService.findByUserName(userName)

        if (isUserLoginSuccess(user, hashedPassword)) {
            val updatedUser = if (!tokenIsAlive(user?.token)) {
                storageService.save(updateToken(requireNotNull(user)))
            } else {
                user!!
            }

            return LoginResult.success(updatedUser.token!!)
        }

        return LoginResult.failed()
    }

    override fun tokenExchange(token: String): TokenExchangeResult {
        val user = storageService.findByToken(token) ?: return TokenExchangeResult.failed()
        if (!tokenIsAlive(user.token)) {
            return TokenExchangeResult.expired()
        }
        return TokenExchangeResult.success(user)
    }

    private fun updateToken(user: User): User {
        return user.copy(token = UserToken.new(randomTokenGenerator(), Instant.now()))
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun randomTokenGenerator(): String {
        val random = ThreadLocalRandom.current()
        val bytes = mutableListOf<Byte>()
        repeat(10) {
            bytes.add(random.nextInt().toByte())
        }

        md5MessageDigest.update(bytes.toByteArray())

        return md5MessageDigest.digest().toHexString(HexFormat.UpperCase)
    }

    private fun tokenIsAlive(token: UserToken?) = token != null && Instant.now().isBefore(token.willExpire)

    private fun isUserLoginSuccess(user: User?, hashedPassword: String): Boolean =
        user != null && user.hashedPassword == hashedPassword

}