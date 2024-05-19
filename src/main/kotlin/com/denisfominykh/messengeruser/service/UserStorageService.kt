package com.denisfominykh.messengeruser.service

import com.denisfominykh.messengeruser.exception.UserNotFoundException
import com.denisfominykh.messengeruser.user.User

interface UserStorageService {
    fun findByIdOrThrow(id: Long) = find(id) ?: throw UserNotFoundException(id)

    fun find(id: Long): User?

    fun findByUserName(userName: String): User?

    fun save(user: User): User

    fun existsByUsername(username: String): Boolean

    fun findLastId(): Long

    fun findByToken(token: String): User?
}
