package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun createLotto(): Lotto = Lotto(drawNumbers())

    private fun drawNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(1, 45, 6)
}