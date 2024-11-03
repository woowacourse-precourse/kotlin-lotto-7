package lotto

data class PurchasedLotto(
    var amountOfLotto: Int = 0,
    var purchasedLotto: MutableList<List<Int>> = mutableListOf()
)

@JvmInline
value class WinningNumbers(val winningNumbers: List<Int>)

@JvmInline
value class BonusNumber(val bonusNumber: Int)

enum class WinnerRank(val standard: String, val prize: Int) {
    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000),
}