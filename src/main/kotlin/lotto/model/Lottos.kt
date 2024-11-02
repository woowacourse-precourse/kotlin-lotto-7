package lotto.model

import  camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants

class Lottos {
    private val lottos = mutableListOf<Lotto>()

    fun buyLottos(price: Int) {
        val count = price / Constants.LOTTO_PRICE
        repeat(count) {
            lottos.add(
                Lotto(
                    Randoms.pickUniqueNumbersInRange(
                        Constants.RANDOM_MIN,
                        Constants.RANDOM_MAX,
                        Constants.LOTTO_SIZE
                    )
                )
            )
        }
    }

    fun size(): Int {
        return lottos.size
    }

    fun getLottos(): List<Lotto> {
        return lottos
    }
}