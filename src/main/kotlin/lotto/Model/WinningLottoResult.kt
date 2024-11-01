package lotto.Model

import lotto.Lotto

class WinningLottoResult(private val winningLotto: Lotto, private val bonusNumber: Int) {
    fun getWinningLotto(): Lotto {
        return winningLotto
    }

    fun getBonusNumber(): Int {
        return bonusNumber
    }
}