package lotto

class TotalLottoResult(
    private val purchasedLotto: PurchasedLotto,
    private val winningNumbers: WinningNumbers,
    private val bonusNumber: BonusNumber
) {
    val winningStatus = mutableMapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0)

    init {
        checkAllLotto()
    }

    fun checkAllLotto() {
        purchasedLotto.purchasedLotto.forEach {
            val rank = Lotto(it).checkRank(winningNumbers, bonusNumber)

            if (rank > 0) {
                winningStatus[rank] = winningStatus[rank]!! + 1
            }
        }
    }
}