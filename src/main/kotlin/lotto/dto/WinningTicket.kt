package lotto.dto

import lotto.model.Lotto

data class WinningTicket(
    val lotto: Lotto,
    val bonusNumber: Int
)