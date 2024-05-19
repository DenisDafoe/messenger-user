package com.denisfominykh.messengeruser.view

import com.denisfominykh.messengeruser.region.Region
import com.denisfominykh.messengeruser.result.ExchangeStatus
import com.denisfominykh.messengeruser.result.TokenExchangeResult

data class TokenExchangeView(
    val exchangeStatus: ExchangeStatus,
    val id: Long?,
    val region: Region?,
) {
    companion object {
        fun fromCore(core: TokenExchangeResult) =
            TokenExchangeView(
                core.exchangeStatus,
                core.id,
                core.region,
            )
    }
}
