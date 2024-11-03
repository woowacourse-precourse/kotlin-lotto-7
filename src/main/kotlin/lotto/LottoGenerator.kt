package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator() {

    fun generateLotto(): Lotto {
        val number = lottoGenerator()
        return Lotto(number.sorted())
    }

    private fun lottoGenerator(): List<Int> =
        Randoms.pickUniqueNumbersInRange(
            LottoMachine.LOTTO_MIN_NUM,
            LottoMachine.LOTTO_MAX_NUM,
            LottoMachine.LOTTO_COUNT
        )
}