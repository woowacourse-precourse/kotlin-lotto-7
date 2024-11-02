package lotto

data class PurchasedLotto(
    var amountOfLotto: Int = 0,
    var purchasedLotto: MutableList<List<Int>> = mutableListOf()
)

@JvmInline
value class WinningNumbers(val winningNumbers: List<Int>)

@JvmInline
value class BonusNumber(val bonusNumber: Int)