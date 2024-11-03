package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto

class LottoService {

    fun calculateQuantity(money: Int): Int = money / 1000


    fun generateLotto(quantity: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        for (i in 1..quantity) {
            val lotto = generateNumbers()
            lottos.add(lotto)
        }
        return lottos
    }

    private fun generateNumbers(): Lotto {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .sorted()
            .let { Lotto(it) }
    }


}