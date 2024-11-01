package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.entity.Lotto

class LottoService {
    fun createRandomLotto() = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))

    fun matchLotto(winLotto: Lotto, comparingLotto: Lotto, bonusNumber: Int): Pair<Int, Boolean> {
        val matchAmount = winLotto.nums.intersect(comparingLotto.nums.toSet()).size
        val hasBonus = comparingLotto.nums.contains(bonusNumber)
        return matchAmount to hasBonus
    }
}