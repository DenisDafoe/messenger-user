package com.denisfominykh.messengeruser.view

import com.denisfominykh.messengeruser.region.Region

data class RegisterBody(
    val userName: String,
    val region: Region,
    val hashedPassword: String
)
