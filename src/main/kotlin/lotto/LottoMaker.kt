package lotto

class LottoMaker {
    private val randomNumber = RandomNumber()
    private val output = Output()

    private fun getLottoCount(inputAmount : Int): Int {
        return inputAmount.div(LOTTO_AMOUNT)
    }

    fun makeLottos(inputAmount : Int): List<Lotto> {
        val lottoCount = getLottoCount(inputAmount)
        val lottoNumber = randomNumber.randomLottos(lottoCount)

        output.printLottoNumbers(lottoNumber)
        return lottoNumber.map { Lotto(it) }
    }
}