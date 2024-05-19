package com.denisfominykh.messengeruser.view

data class LoginBody(
    val userName: String,
    val hashedPassword: String
)