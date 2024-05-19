package com.denisfominykh.messengeruser.view

import com.denisfominykh.messengeruser.result.LoginResult
import com.denisfominykh.messengeruser.result.LoginStatus
import com.denisfominykh.messengeruser.tool.UserToken


data class LoginView(
    val status: LoginStatus,
    val userToken: UserToken? = null,
) {
    companion object {
        fun fromCore(core: LoginResult) =
            LoginView(
                core.status,
                core.userToken,
            )
    }
}
