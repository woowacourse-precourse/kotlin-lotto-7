package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.entity.Lotto
import lotto.domain.entity.WinningLotto
import lotto.domain.entity.increase
import java.text.DecimalFormat

class LottoService {
    fun matchAllLotto(winLotto: Lotto, comparingLottos: List<Lotto>, bonusNumber: Int) {
        comparingLottos.forEach {
            val (matchAmount, hasBonus) = matchLotto(winLotto, it, bonusNumber)
            winStatusUpdate(matchAmount, hasBonus)
        }
    }

    fun purchaseLottos(money: Int): List<Lotto> {
        val amount = money / LOTTO_PRICE
        val lottos = mutableListOf<Lotto>()
        repeat(amount) { lottos += createRandomLotto() }
        return lottos
    }

    fun getResultMoney(): Int {
        var result = 0
        for (lotto in WinningLotto.entries) {
            result += lotto.rewardPrice * lotto.amount
        }
        return result
    }

    fun getProfitRate(originalMoney: Int, resultMoney: Int): String {
        val profit = resultMoney.toDouble() / originalMoney.toDouble() * 100
        val decimalFormat = DecimalFormat("#,##0.0")
        return decimalFormat.format(profit)
    }

    private fun createRandomLotto() = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())

    private fun matchLotto(winLotto: Lotto, comparingLotto: Lotto, bonusNumber: Int): Pair<Int, Boolean> {
        val matchAmount = winLotto.getNumbers().intersect(comparingLotto.getNumbers().toSet()).size
        val hasBonus = comparingLotto.getNumbers().contains(bonusNumber)
        return matchAmount to hasBonus
    }

    private fun winStatusUpdate(matchAmount: Int, hasBonus: Boolean) {
        if (matchAmount == 5 && hasBonus) {
            WinningLotto.FiveBonus.increase()
            return
        }
        when (matchAmount) {
            3 -> WinningLotto.Three.increase()
            4 -> WinningLotto.Four.increase()
            5 -> WinningLotto.Five.increase()
            6 -> WinningLotto.Six.increase()
        }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}