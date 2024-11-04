package lotto

import lotto.domain.model.Lotto
import lotto.domain.model.LottoWinPlace
import lotto.domain.model.factory.LottoFactory
import lotto.ui.InputView
import lotto.ui.OutputView
import lotto.util.keepCallingForSuccessResult

class LottoApp(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val lottoFactory: LottoFactory
) {
    fun run() {
        val budget = keepCallingWithDefaultOnFailure(inputView::requestBudget)

        val amount = budget / Lotto.LOTTO_PRICE
        outputView.displayAmount(amount)

        val lottoes = lottoFactory.createLottoes(amount)
        outputView.displayLottoes(lottoes)

        val winningNumbers = keepCallingWithDefaultOnFailure(inputView::requestWinningNumbers)
        val bonusWinningNumber = keepCallingWithDefaultOnFailure { inputView.requestBonusWinningNumber(winningNumbers) }

        val lottoWinPlaces = lottoes.calculateAllLottoWinPlaces(winningNumbers, bonusWinningNumber)
        outputView.displayLottoResults(lottoWinPlaces)
    }

    private fun List<Lotto>.calculateAllLottoWinPlaces(
        winningNumbers: List<Int>,
        bonusWinningNumber: Int
    ): Map<LottoWinPlace, Int> =
        mapNotNull { it.calculateWinPlace(winningNumbers, bonusWinningNumber) }.groupingBy { it }.eachCount()

    private fun <R> keepCallingWithDefaultOnFailure(actionToCall: () -> Result<R>): R = keepCallingForSuccessResult(
        onFailure = outputView::displayExceptionMessage,
        actionToCall = actionToCall,
    )
}
