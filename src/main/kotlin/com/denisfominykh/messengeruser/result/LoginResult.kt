package com.denisfominykh.messengeruser.result

import com.denisfominykh.messengeruser.tool.UserToken

class LoginResult(
    val status: LoginStatus,
    val userToken: UserToken? = null,
) {
    companion object {
        fun success(token: UserToken) =
            LoginResult(
                LoginStatus.SUCCESSFUL,
                token,
            )

        fun failed() =
            LoginResult(
                LoginStatus.FAILED,
            )
    }
}

enum class LoginStatus {
    FAILED,
    SUCCESSFUL,
}
