package com.denisfominykh.messengeruser.tool

import java.time.Duration
import java.time.Instant

class UserToken(
    val token: String,
    val willExpire: Instant,
) {
    companion object {
        private val DEFAULT_TTL = Duration.parse("PT2H")!!

        fun new(
            token: String,
            currentInstant: Instant,
        ) = UserToken(
            token,
            currentInstant.plusSeconds(DEFAULT_TTL.toSeconds()),
        )
    }
}
