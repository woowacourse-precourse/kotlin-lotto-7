package lotto.dto

import lotto.Lotto
import lotto.constant.Prize

class LottoResult(
    private val lottos: List<Lotto>,
    private val winningNumber: WinningNumber,
) {
    private val result: MutableList<Int> = MutableList<Int>(5) { 0 }

    fun compareLottosWithWinningNumber() {
        lottos.forEach {
            when (it.compareWithLotto(winningNumber.getLotto())) {
                Prize.FIRST.match -> result[0] += 1
                Prize.THIRD.match -> {
                    if (it.compareWithBonus(winningNumber.getBonus())) result[1] += 1
                    else result[2] += 1
                }

                Prize.FORTH.match -> result[3] += 1
                Prize.FIFTH.match -> result[4] += 1
                else -> {}
            }

        }
    }

    companion object {

    }
}