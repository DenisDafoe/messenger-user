package com.denisfominykh.messengeruser.user

import com.denisfominykh.messengeruser.region.Region
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
class UserModel(
    @Id
    val id: Long,
    val userName: String,
    val region: Region,
    val hashedPassword: String,
    val salt: String,
    val token: UserTokenModel?,
) {
    fun intoCore() =
        User(
            id,
            userName,
            region,
            hashedPassword,
            salt,
            token?.intoCore(),
        )

    companion object {
        fun fromCore(user: User) =
            UserModel(
                user.id,
                user.username,
                user.region,
                user.hashedPassword,
                user.salt,
                UserTokenModel.fromCoreNullable(user.token),
            )
    }
}
