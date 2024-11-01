package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var lottoTickets = mutableListOf<Lotto>()

    fun start() {
        val lottoAmount = inputView.getLottoAmount()

        val lottoCount = lottoAmount / Constants.LOTTO_PRICE
        outputView.printLottoAmountMessage(lottoCount)

        generateLotto(lottoCount)
        printLottoNumber()

        val winningNumbers = inputView.getWinningNumbers()

        val bonusNumber = inputView.getBonusNumber(winningNumbers)
    }

    private fun generateLotto(lottoCount: Int) {
        repeat(lottoCount) {
            val lottoNumbers = Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_NUMBER_MIN,
                Constants.LOTTO_NUMBER_MAX,
                Constants.LOTTO_NUMBERS_SIZE
            )
            lottoTickets.add(Lotto(lottoNumbers))
        }
    }

    private fun printLottoNumber() {
        lottoTickets.forEach { lotto -> println(lotto.getNumbers()) }
    }
}