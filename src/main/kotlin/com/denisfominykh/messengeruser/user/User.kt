package com.denisfominykh.messengeruser.user

import com.denisfominykh.messengeruser.region.Region
import com.denisfominykh.messengeruser.tool.UserToken

data class User(
    val id: Long,
    val username: String,
    val region: Region,
    val hashedPassword: String,
    val token: UserToken?,
)
