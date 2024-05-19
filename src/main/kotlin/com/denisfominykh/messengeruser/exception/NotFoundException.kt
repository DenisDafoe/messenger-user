package com.denisfominykh.messengeruser.exception

import java.rmi.UnexpectedException

abstract class NotFoundException(inpMessage: String): UnexpectedException(inpMessage)