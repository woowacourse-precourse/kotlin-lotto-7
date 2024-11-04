package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.constant.LottoRules

class LottoFactory(private val purchaseAmount: Int) {
    val lottoQuantity: Int = purchaseAmount / LottoRules.AMOUNT_UNIT

    fun getPurchaseAmount(): Int = purchaseAmount

    fun createLotto(): List<Lotto> {
        val lottoList: MutableList<Lotto> = mutableListOf()
        repeat(lottoQuantity) {
            val numbers = createNumber()
            val lotto = Lotto(numbers)
            lottoList.add(lotto)
        }
        return lottoList
    }

    private fun createNumber(): List<Int> {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(
            LottoRules.LOTTO_NUMBER_MIN,
            LottoRules.LOTTO_NUMBER_MAX,
            LottoRules.LOTTO_NUMBER_COUNT
        ).sorted()
        return randomNumbers
    }
}