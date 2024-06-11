package com.denisfominykh.messengeruser.user.service

import com.denisfominykh.messengeruser.sequence.SequenceModel
import com.denisfominykh.messengeruser.sequence.repository.SequenceRepository
import com.denisfominykh.messengeruser.service.UserStorageService
import com.denisfominykh.messengeruser.user.User
import com.denisfominykh.messengeruser.user.UserModel
import com.denisfominykh.messengeruser.user.exception.SequenceNotFoundException
import com.denisfominykh.messengeruser.user.repository.UserRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class UserStorageServiceImpl(
    private val repository: UserRepository,
    private val sequenceRepository: SequenceRepository,
) : UserStorageService {
    override fun find(id: Long): User? {
        return repository.findById(id).getOrNull()?.intoCore()
    }

    override fun findByUserName(userName: String): User? {
        return repository.findByUserName(userName)?.intoCore()
    }

    override fun save(user: User): User {
        increaseSequence(user.id)
        return repository.save(UserModel.fromCore(user)).intoCore()
    }

    override fun existsByUsername(username: String): Boolean {
        return repository.existsByUserName(username)
    }

    override fun findLastId(): Long {
        val lastValue = sequenceRepository.findById("user").getOrNull()
        if (lastValue == null) {
            sequenceRepository.save(
                SequenceModel(
                    "user",
                    1,
                ),
            )
        }
        return sequenceRepository.findByName("user")?.lastValue ?: throw SequenceNotFoundException("user")
    }

    override fun findByToken(token: String): User? {
        return repository.findByToken_Token(token)?.intoCore()
    }

    private fun increaseSequence(persistedId: Long) {
        sequenceRepository.save(SequenceModel("user", persistedId))
    }
}
