package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val lottoAmount = inputView.getLottoAmount()

        val lottoCount = lottoAmount / Constants.LOTTO_PRICE
        outputView.printLottoAmountMessage(lottoCount)

        printLottoNumber(lottoCount)

        val winningNumbers = inputView.getWinningNumbers()

        val bonusNumber = inputView.getBonusNumber(winningNumbers)
    }

    private fun printLottoNumber(lottoCount: Int) {
        repeat(lottoCount) {
            val lottoNumbers = Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_NUMBER_MIN,
                Constants.LOTTO_NUMBER_MAX,
                Constants.LOTTO_NUMBERS_SIZE
            )
            println(lottoNumbers.sorted().joinToString(prefix = "[", postfix = "]"))
        }
        println()
    }
}