package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val lottoCount: Int) {

    fun createLotto(): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(lottoCount) {
            val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            val lotto = Lotto(lottoNumber)
            lottos.add(lotto)
        }

        return lottos
    }
}