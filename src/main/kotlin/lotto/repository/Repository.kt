package lotto.repository

import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.domain.PurchaseAmount
import camp.nextstep.edu.missionutils.Randoms

class Repository {
    lateinit var winningNumber: Lotto
    lateinit var purchaseAmount: PurchaseAmount
    lateinit var bonusNumber: BonusNumber

    var lottos: MutableList<Lotto> = mutableListOf()

    fun setPurchaseAmount(number: Int) {
        purchaseAmount = PurchaseAmount(number)
    }

    fun setWinningNumber(number: List<Int>) {
        winningNumber = Lotto(number)
    }

    fun setBonusNumber(number: Int) {
        bonusNumber = BonusNumber(number, winningNumber)
    }

    fun createLottos() {
        val lottoCnt = purchaseAmount.getPurchaseAmount() / 1000
        for (i in 0 until lottoCnt) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            lottos.addAll(listOf(Lotto(numbers)))
        }
    }
}