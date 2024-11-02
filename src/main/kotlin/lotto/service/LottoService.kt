package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.entity.Lotto

class LottoService {
    private fun createRandomLotto() = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())

    fun matchLotto(winLotto: Lotto, comparingLotto: Lotto, bonusNumber: Int): Pair<Int, Boolean> {
        val matchAmount = winLotto.nums.intersect(comparingLotto.nums.toSet()).size
        val hasBonus = comparingLotto.nums.contains(bonusNumber)
        return matchAmount to hasBonus
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