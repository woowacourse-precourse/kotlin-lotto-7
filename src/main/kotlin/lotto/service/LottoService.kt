package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.entity.Lotto
import lotto.domain.entity.WinningLotto
import lotto.domain.entity.increase

class LottoService {
    private fun createRandomLotto() = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())

    fun matchLotto(winLotto: Lotto, comparingLotto: Lotto, bonusNumber: Int): Pair<Int, Boolean> {
        val matchAmount = winLotto.nums.intersect(comparingLotto.nums.toSet()).size
        val hasBonus = comparingLotto.nums.contains(bonusNumber)
        return matchAmount to hasBonus
    }

    fun matchAllLotto(winLotto: Lotto, comparingLottos: List<Lotto>, bonusNumber: Int) {
        comparingLottos.forEach {
            val (matchAmount, hasBonus) = matchLotto(winLotto, it, bonusNumber)
            winStatusUpdate(matchAmount, hasBonus)
        }
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

    fun purchaseLottos(money: Int): List<Lotto> {
        val amount = money / LOTTO_PRICE
        val lottos = mutableListOf<Lotto>()
        repeat(amount) { lottos += createRandomLotto() }
        return lottos
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}