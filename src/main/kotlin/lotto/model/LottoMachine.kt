package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto.Companion.LOTTO_MAXIMUM_NUMBER
import lotto.model.Lotto.Companion.LOTTO_MINIMUM_NUMBER
import lotto.model.Lotto.Companion.LOTTO_NUMBER_SIZE

class LottoMachine {

    fun createLottos(lottoCount: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(lottoCount) {
            val lottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER, LOTTO_NUMBER_SIZE)
            val lotto = Lotto(lottoNumber)
            lottos.add(lotto)
        }

        return lottos
    }
}