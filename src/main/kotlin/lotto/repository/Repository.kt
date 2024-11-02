package lotto.repository

import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.domain.PurchaseAmount

class Repository {
    lateinit var winningNumber: Lotto
    lateinit var purchaseAmount: PurchaseAmount
    lateinit var bonusNumber: BonusNumber

    fun setPurchaseAmount(number: Int) {
        purchaseAmount = PurchaseAmount(number)
    }

    fun setWinningNumber(number: List<Int>) {
        winningNumber = Lotto(number)
    }

    fun setBonusNumber(number: Int) {
        bonusNumber = BonusNumber(number)
    }
}