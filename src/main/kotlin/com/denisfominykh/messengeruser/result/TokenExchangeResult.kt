package com.denisfominykh.messengeruser.result

import com.denisfominykh.messengeruser.region.Region
import com.denisfominykh.messengeruser.user.User

class TokenExchangeResult(
    val exchangeStatus: ExchangeStatus,
    val id: Long? = null,
    val region: Region? = null,
) {
    companion object {
        fun failed() =
            TokenExchangeResult(
                ExchangeStatus.NOT_FOUND,
            )

        fun success(user: User) =
            TokenExchangeResult(
                ExchangeStatus.SUCCESSFUL,
                user.id,
                user.region,
            )

        fun expired() =
            TokenExchangeResult(
                ExchangeStatus.EXPIRED,
            )
    }
}

enum class ExchangeStatus {
    SUCCESSFUL,
    NOT_FOUND,
    EXPIRED,
}
