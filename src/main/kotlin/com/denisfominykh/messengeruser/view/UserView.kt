package com.denisfominykh.messengeruser.view

import com.denisfominykh.messengeruser.user.User

data class UserView(
    val id: Long,
    val userName: String
) {
    companion object {
        fun fromUser(user: User): UserView {
            return UserView(user.id, user.username)
        }
    }
}