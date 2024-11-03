package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val payment: String) {

    fun calculateTotalLottoCount(): Int {
        return payment.toInt() / LOTTO_PRICE
    }

    fun generateLotto(): Lotto {
        val number = lottoGenerator()
        return Lotto(number)
    }

    private fun lottoGenerator(): MutableList<Int> =
        Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_COUNT)


    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_MIN_NUM = 1
        const val LOTTO_MAX_NUM = 45
        const val LOTTO_COUNT = 6
    }
}