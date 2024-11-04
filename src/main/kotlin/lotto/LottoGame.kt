package lotto

import lotto.domain.WinningLotto
import lotto.domain.generator.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val lottoGenerator: LottoGenerator,
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun play() {
        val purchaseAmount = getPurchaseAmount()
        val lottos = buyLottos(purchaseAmount)
        val winningLotto = getWinningLotto()
        val result = LottoResult(lottos, winningLotto, purchaseAmount)

        displayResults(result)
    }

    private fun getPurchaseAmount(): Int =
        try {
            val amount = inputView.readPurchaseAmount()
            validatePurchaseAmount(amount)
            amount
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getPurchaseAmount()
        }

    private fun validatePurchaseAmount(amount: Int) {
        require(amount >= Lotto.PRICE) { lottoMoneyError() }
        require(amount % Lotto.PRICE == 0) { lottoUnitError() }
    }

    private fun buyLottos(amount: Int): List<Lotto> {
        val lottos = lottoGenerator.createLottos(amount)
        outputView.printPurchaseResult(lottos)
        return lottos
    }

    private fun getWinningLotto(): WinningLotto =
        try {
            val numbers = inputView.readWinningNumbers()
            val bonusNumber = inputView.readBonusNumber()
            WinningLotto(numbers, bonusNumber)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getWinningLotto()
        }

    private fun displayResults(result: LottoResult) {
        outputView.printWinningStatistics(
            result.getWinningStatistics(),
            result.calculateProfitRate(),
        )
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR] "

        private fun sendError(message: String): String = ERROR_PREFIX + message

        fun lottoMoneyError(): String = sendError("로또의 최소 구매 금액은 ${Lotto.PRICE}원입니다.")

        fun lottoUnitError(): String = sendError("로또는 ${Lotto.PRICE}원 단위로 구매 가능합니다.")
    }
}
