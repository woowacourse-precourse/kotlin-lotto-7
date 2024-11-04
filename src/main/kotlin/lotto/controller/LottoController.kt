package lotto.controller

import lotto.constants.Constants.DELIMITER
import lotto.constants.Constants.PRICE_UNIT
import lotto.model.Lotto
import lotto.model.Statistics
import lotto.service.LottoService
import lotto.util.Validator
import lotto.util.safeInputCall
import lotto.util.toIntOrException
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView = InputView(),
    private val lottoService: LottoService = LottoService(),
    private val outputView: OutputView = OutputView()
) {
    private lateinit var statistics: Statistics
    fun run() {
        setUp()
        outputView.printStatistics(statistics)

        inputView.close()
    }

    private fun setUp() {
        val lottoPrice = inputView.getPriceInput()
        val lottoList = lottoService.generateLottoList(count = lottoPrice / PRICE_UNIT)
        outputView.printPurchaseHistory(lottoList)

        val winningNumbers = inputView.getWinningNumbersInput()
        val bonusNumber = inputView.getBonusNumberInput()
        statistics = lottoService.getStatistics(lottoPrice, lottoList, winningNumbers, bonusNumber)
    }
}