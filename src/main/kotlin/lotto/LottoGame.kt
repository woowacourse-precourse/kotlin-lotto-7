package lotto

class LottoGame {
    private val lottoInput = LottoInput()
    private val validator = Validator()

    fun startLotto() {
        val purchasePrice = checkValidatedPurchaseAmount()
    }

    private fun checkValidatedPurchaseAmount(): Int {
        return generateSequence {
            val input = lottoInput.getPurchasePrice()
            validator.validatePurchasePrice(input)
        }.firstNotNullOfOrNull { it } ?: checkValidatedPurchaseAmount()
    }
}