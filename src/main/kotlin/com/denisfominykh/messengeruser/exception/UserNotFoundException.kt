package com.denisfominykh.messengeruser.exception

import com.denisfominykh.messengeruser.exception.NotFoundException

class UserNotFoundException(
    id: Long,
) : NotFoundException("User with id=$id not found")
