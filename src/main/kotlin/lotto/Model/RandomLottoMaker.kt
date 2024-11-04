package lotto.Model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object RandomLottoMaker {
    fun makeLottos(count: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(count) {
            lottos.add(makeLotto())
        }
        return lottos
    }

    private fun makeLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        numbers.sort()
        return Lotto(numbers)
    }
}