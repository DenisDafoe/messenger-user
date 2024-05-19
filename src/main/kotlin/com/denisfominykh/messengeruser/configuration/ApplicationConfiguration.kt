package com.denisfominykh.messengeruser.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.security.MessageDigest

@Configuration
class ApplicationConfiguration {
    @Bean
    fun md5MessageDigest(): MessageDigest? {
        return MessageDigest.getInstance("MD5")
    }
}
