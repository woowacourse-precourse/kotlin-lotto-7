package lotto.controller

import lotto.model.LottoGame
import lotto.parser.Parser
import lotto.util.Constants
import lotto.validator.Validator
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    private val validator = Validator()
    private val parser = Parser()
    private val inputView = InputView(validator, parser)
    private val resultView = ResultView()
    private val lottoGame = LottoGame()

    fun start() {
        val purchaseAmount = inputView.inputPurchaseAmount()
        val lottoCount = purchaseAmount / Constants.LOTTO_UNIT_PRICE
        val lottos = lottoGame.generateLotto(lottoCount)

        resultView.displayPurchasedLotto(lottoCount, lottos)

        val winningNumbers = inputView.inputWinningNumbers()
    }
}