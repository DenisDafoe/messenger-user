package com.denisfominykh.messengeruser.user.repository

import com.denisfominykh.messengeruser.user.UserModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<UserModel, Long> {
    fun findByUserName(userName: String): UserModel?

    fun existsByUserName(username: String): Boolean

//    @Query(value = "{'token.token': '?token'}")
//    fun findByTokenValue(token: String): UserModel?
    fun findByToken_Token(token: String): UserModel?
}
