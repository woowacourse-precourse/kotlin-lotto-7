package lotto.domain

class Lottos(
    private val purchaseCount: Int,
) {

    private val _lottos = mutableListOf<Lotto>()
    val lottos: List<Lotto>
        get() = _lottos.toList()

    init {
        validatePurchaseCountPositive(purchaseCount)
        createLottos(purchaseCount)
    }

    private fun validatePurchaseCountPositive(purchaseCount: Int) =
        require(purchaseCount > MIN_COUNT) { PURCHASE_COUNT_ERROR_MESSAGE }

    private fun createLottos(lottoAmount: Int) =
        repeat(lottoAmount) {
            val randomNumbers = generateRandomNumbers()
            val lotto = Lotto(randomNumbers)
            storeLotto(lotto)
        }

    private fun generateRandomNumbers(): List<Int> {
        val randomNumber = RandomNumbersGenerator().generate()
        return randomNumber
    }

    private fun storeLotto(lotto: Lotto) = _lottos.add(lotto)

    companion object {
        private const val PURCHASE_COUNT_ERROR_MESSAGE = "로또 구매 수량은 1개 이상이여야 합니다."
        private const val MIN_COUNT = 0
    }

}
