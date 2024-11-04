package lotto.dto

import lotto.Lotto

class WinningNumber(private val winningNumber: Pair<Lotto, Bonus>) {
    init {
        require(
            !winningNumber.first.getLotto().contains(winningNumber.second.getBonusNumber())
        ) { "[ERROR] 당첨 번호와 보너스 번호간에 중복된 숫자가 존재합니다. " }
    }

    fun getLotto(): Lotto = winningNumber.first

    fun getBonus(): Bonus = winningNumber.second
}