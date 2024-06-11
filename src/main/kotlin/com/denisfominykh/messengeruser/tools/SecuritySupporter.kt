package com.denisfominykh.messengeruser.tools

import org.springframework.stereotype.Component
import java.security.MessageDigest
import java.util.*
import kotlin.text.HexFormat

@Component
class SecuritySupporter(
    private val md5MessageDigest: MessageDigest,
) {
    fun generateSalt(): String {
        return UUID.randomUUID().toString()
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun hashPwdWithSalt(
        password: String,
        salt: String,
    ): String {
        val concat = password + salt
        return md5MessageDigest.digest(concat.toByteArray()).toHexString(HexFormat.UpperCase)
    }
}
