package lotto

class LottoGame {
    private val view = View()
    private val broadcast = Broadcast()

    private lateinit var inputPayment: Payment

    fun start() {
        inputPayment = view.inputPayment()
        val lottoMachine = LottoMachine(inputPayment.getPayment())
        broadcast.printLottoNumbers(lottoMachine.lottoList)

        val winningNumber = view.inputWinningNumber()
        val bonusNumber = view.inputBonusNumber(winningNumber)

    }
}