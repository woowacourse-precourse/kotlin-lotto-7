package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoController {

    val lottos = ArrayList<Lotto>()

    private fun releaseLotto() {
        lottos.add(Lotto(getLottoNumber()))
    }

    private fun getLottoNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}