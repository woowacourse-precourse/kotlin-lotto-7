package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.constant.LottoRules

// 로또를 발행하는 역할(로또 생성)
// 구입금액을 통해 로또를 발행 -> 발행된 로또
// 구입금액 제공
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