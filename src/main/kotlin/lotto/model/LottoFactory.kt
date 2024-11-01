package lotto.model

import camp.nextstep.edu.missionutils.Randoms

// 로또를 발행하는 역할(로또 생성)
// 구입금액을 통해 로또를 발행 -> 발행된 로또
// 구입금액 제공
class LottoFactory(private val purchaseAmountInput: String) {
    val purchaseAmount: Int
    val lottoQuantity: Int

    init {
        purchaseAmount = getValidatePurchaseAmount()
        lottoQuantity = purchaseAmount / 1000
    }

    private fun createNumber(): List<Int> {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
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

    private fun getValidatePurchaseAmount(): Int {
        validatePurchaseAmount()
        val validatedPurchaseAmount = purchaseAmountInput.trim().toInt()
        return validatedPurchaseAmount
    }

    private fun validatePurchaseAmount() {
        require(purchaseAmountInput.isNotEmpty()) { "[ERROR] 구입 금액은 빈 값이 될 수 없습니다." }

        val amount = purchaseAmountInput.trim().toIntOrNull()
        require(amount != null) { "[ERROR] 구입 금액은 숫자여야 합니다." }
        require(amount % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
        require(amount <= 1000000000) { "[ERROR] 구입 금액은 1억원 이하여야 합니다." }
    }
}