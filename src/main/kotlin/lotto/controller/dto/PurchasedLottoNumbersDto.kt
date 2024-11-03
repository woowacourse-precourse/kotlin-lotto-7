package lotto.controller.dto

data class PurchasedLottoNumbersDto(
    val winningNumbers: List<Int>,
    val bonusNumber: Int
)
