package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constant

class LottoHandler {
    fun generateLottos(count: Int) {
        val lottos = mutableSetOf<Lotto>()
        while (lottos.size < count) {
            lottos.add(Lotto(generateRandomNumbers()))
        }
    }

    private fun generateRandomNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(Constant.LOTTO_NUMBER_MIN, Constant.LOTTO_NUMBER_MAX, Constant.LOTTO_NUMBER_COUNT)
        return numbers.sorted()
    }
}
