package com.denisfominykh.messengeruser.service

import com.denisfominykh.messengeruser.region.Region
import com.denisfominykh.messengeruser.result.LoginResult
import com.denisfominykh.messengeruser.result.TokenExchangeResult
import com.denisfominykh.messengeruser.user.User

interface UserService {
    fun registerUser(
        username: String,
        region: Region,
        hashedPassword: String,
    ): User

    fun attemptLogin(
        userName: String,
        hashedPassword: String,
    ): LoginResult

    fun tokenExchange(token: String): TokenExchangeResult
}
