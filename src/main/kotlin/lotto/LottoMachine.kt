package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {

    fun createLottos(lottoCount: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(lottoCount) {
            val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            val lotto = Lotto(lottoNumber)
            lottos.add(lotto)
        }

        return lottos
    }
}