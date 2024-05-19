package com.denisfominykh.messengeruser.user.exception

import com.denisfominykh.messengeruser.exception.NotFoundException

class SequenceNotFoundException(
    name: String,
) : NotFoundException(
        "Sequence $name not found",
    )
