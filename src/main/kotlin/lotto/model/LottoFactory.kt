package lotto.model

import camp.nextstep.edu.missionutils.Randoms

// 로또를 발행하는 역할(로또 생성)
// 구입금액을 통해 로또를 발행 -> 발행된 로또
// 구입금액 제공
class LottoFactory(private val purchaseAmount: Int) {
    val lottoQuantity: Int = purchaseAmount / 1000

    fun getPurchaseAmount(): Int = purchaseAmount

    private fun createNumber(): List<Int> {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return randomNumbers
    }

    fun createLotto(): List<Lotto> {
        val lottoList: MutableList<Lotto> = emptyList<Lotto>().toMutableList()
        repeat(lottoQuantity) {
            val numbers = createNumber()
            val lotto = Lotto(numbers)
            lottoList.add(lotto)
        }
        return lottoList
    }
}