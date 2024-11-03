package lotto

class LottoGame {
    private val lottoInput = LottoInput()
    private val lottoOutput = LottoOutput()
    private val validator = Validator()
    private val lottoMachine = LottoMachine()

    fun startLotto() {
        val purchasePrice = checkValidatedPurchaseAmount()
        val lottoTicketCount = purchasePrice / 1000

        lottoOutput.printTicketCount(lottoTicketCount)

        val lottoTickets = lottoMachine.generateLottoTickets(lottoTicketCount)
        lottoOutput.printLottoTickets(lottoTickets)
    }

    private fun checkValidatedPurchaseAmount(): Int {
        return generateSequence {
            val input = lottoInput.getPurchasePrice()
            validator.validatePurchasePrice(input)
        }.firstNotNullOfOrNull { it } ?: checkValidatedPurchaseAmount()
    }
}