package com.denisfominykh.messengeruser.controller

import com.denisfominykh.messengeruser.view.LoginBody
import com.denisfominykh.messengeruser.view.LoginView
import com.denisfominykh.messengeruser.view.RegisterBody
import com.denisfominykh.messengeruser.view.TokenExchangeView
import com.denisfominykh.messengeruser.view.UserView
import com.denisfominykh.messengeruser.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserInternalController(
    private val userService: UserService,
) {
    @PostMapping("register")
    fun registerUser(
        @RequestBody body: RegisterBody,
    ): UserView {
        return UserView.fromUser(userService.registerUser(body.userName, body.region, body.hashedPassword))
    }

    @PostMapping("login")
    fun login(
        @RequestBody body: LoginBody,
    ): LoginView {
        return LoginView.fromCore(userService.attemptLogin(body.userName, body.hashedPassword))
    }

    @PostMapping("exchange")
    fun exchange(
        @RequestBody token: String,
    ): TokenExchangeView {
        return TokenExchangeView.fromCore(userService.tokenExchange(token))
    }
}
