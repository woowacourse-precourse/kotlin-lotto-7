package lotto.controller

import lotto.domain.GameResult
import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun start() {
        val purchaseAmount = getPurchaseAmount()
        val lottos = generateLottos(purchaseAmount.getCount())
        val winningNumber = getWinningNumber()

        val gameResult = calculateGameResult(lottos, winningNumber)
        OutputView.printGameResult(gameResult)
    }

    private fun getPurchaseAmount(): PurchaseAmount {
        val purchaseAmount = InputView.inputPurchaseMoney()
        OutputView.printPurchaseAmount(purchaseAmount.getCount())
        return purchaseAmount
    }

    private fun generateLottos(count: Int): List<Lotto> {
        val lottos = List(count) { LottoGenerator().generate() }
        lottos.forEach { OutputView.printLottoNumbers(it) }
        return lottos
    }

    private fun getWinningNumber(): WinningNumber {
        val lottoNumbers = InputView.inputLottoNumbers()
        val bonusNumber = InputView.inputBonusNumber(lottoNumbers.getNumbers())
        return WinningNumber(lottoNumbers.getNumbers(), bonusNumber)
    }

    private fun calculateGameResult(lottos: List<Lotto>, winningNumber: WinningNumber): GameResult {
        val gameResult = GameResult()
        lottos.forEach { lotto ->
            val rank = winningNumber.getRank(lotto)
            gameResult.addWinningDetail(rank)
        }
        return gameResult
    }
}