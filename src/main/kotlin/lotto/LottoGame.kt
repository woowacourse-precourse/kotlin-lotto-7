package lotto

class LottoGame {
    private val view = View()
    private val broadcast = Broadcast()

    private lateinit var inputPayment: Payment

    fun start() {
        inputPayment = view.inputPayment()
        val lottoMachine = LottoMachine(inputPayment.getPayment())
        val lottoCount = lottoMachine.calculateTotalLottoCount()
        val lottoList = lottoMachine.makeLotto(lottoCount)
        broadcast.printLottoNumbers(lottoList)
    }
}