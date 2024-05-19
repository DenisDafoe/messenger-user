package com.denisfominykh.messengeruser.exception

class UserAlreadyExistsException(
    username: String
): Exception("User with username $username already exists")