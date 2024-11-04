package lotto.model

data class LottoWinning(
    var numbers: List<Int> = listOf(),
    var bonus: Int = 0,
)