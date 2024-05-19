package com.denisfominykh.messengeruser.user

import com.denisfominykh.messengeruser.tool.UserToken
import java.time.Instant

class UserTokenModel(
    val token: String,
    val willExpire: Instant,
) {
    fun intoCore() = UserToken(
        token,
        willExpire
    )

    companion object {
        fun fromCoreNullable(token: UserToken?): UserTokenModel? {
            if (token == null) {
                return null
            }
            return UserTokenModel(
                token.token,
                token.willExpire
            )
        }
    }
}