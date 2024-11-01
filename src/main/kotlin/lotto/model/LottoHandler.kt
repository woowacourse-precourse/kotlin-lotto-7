package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constant

class LottoHandler {
    fun generateLottos(count: Int): Set<Lotto> {
        val lottos = mutableSetOf<Lotto>()
        while (lottos.size < count) {
            lottos.add(Lotto(generateRandomNumbers()))
        }
        return lottos
    }

    private fun generateRandomNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(Constant.LOTTO_NUMBER_MIN, Constant.LOTTO_NUMBER_MAX, Constant.LOTTO_NUMBER_COUNT)
        return numbers.sorted()
    }
}
