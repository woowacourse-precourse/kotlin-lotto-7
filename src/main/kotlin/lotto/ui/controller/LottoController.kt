package lotto.ui.controller

import lotto.common.LOTTO_PRICE
import lotto.di.AppContainer
import lotto.domain.entity.BonusNumber
import lotto.domain.entity.Lotto
import lotto.domain.entity.User
import lotto.domain.entity.WinningNumbers
import lotto.ui.view.LottoBuyView
import lotto.ui.view.LottoResultView
import lotto.ui.view.WinningNumberInputView

class LottoController(
    appContainer: AppContainer,
    private val lottoBuyView: LottoBuyView,
    private val winningNumberInputView: WinningNumberInputView,
    private val lottoResultView: LottoResultView
) {

    private val createUserUseCase = appContainer.createUserUseCase
    private val createLottoUseCase = appContainer.createLottoUseCase
    private val createWinningNumbersUseCase = appContainer.createWinningNumbersUseCase
    private val createBonusNumberUseCase = appContainer.createBonusNumberUseCase
    private val calculateLottoRankUseCase = appContainer.calculateLottoRankUseCase
    private val calculateLottoReturnUseCase = appContainer.calculateLottoReturnUseCase

    fun run() {
        val user = getUser()
        buyLottoTickets(user)
        showLottoTicketsResult(user)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers.getNumbers())
        showLottoResult(user.getLottoTickets(), winningNumbers, bonusNumber)
    }

    private fun getUser(): User {
        lottoBuyView.guidePurchaseAmount()
        return createUserUseCase.execute { lottoBuyView.inputPurchaseAmount() }
    }

    private fun buyLottoTickets(user: User) {
        user.buyLottoTickets { lottoCount ->
            List(lottoCount) { createLottoUseCase.execute() }
        }
    }

    private fun showLottoTicketsResult(user: User) {
        lottoBuyView.guidePurchaseLottoCount(user.getLottoTickets().count())
        lottoBuyView.guideLottoNumbers(user.getLottoTickets())
    }

    private fun getWinningNumbers(): WinningNumbers {
        val winningNumbers = {
            winningNumberInputView.guideWinningNumbers()
            winningNumberInputView.inputWinningNumbers()
        }
        return createWinningNumbersUseCase.execute(winningNumbers)
    }

    private fun getBonusNumber(winningNumbers: List<Int>): BonusNumber {
        val bonusNumber = {
            winningNumberInputView.guideBonusNumber()
            winningNumberInputView.inputBonusNumber()
        }
        return createBonusNumberUseCase.execute(bonusNumber, winningNumbers)
    }

    private fun showLottoResult(lottoTickets: List<Lotto>, winningNumbers: WinningNumbers, bonusNumber: BonusNumber) {
        val lottoTicketsRank = lottoTickets.map { lotto ->
            calculateLottoRankUseCase.execute(lotto, winningNumbers, bonusNumber)
        }
        lottoResultView.outputWinningStatistics(lottoTicketsRank)
        val winningPrizes = lottoTicketsRank.map { it.prize }
        val lottoTotalProfitRate =
            calculateLottoReturnUseCase.execute(winningPrizes, lottoTickets.size.times(LOTTO_PRICE))
        lottoResultView.outputTotalProfitRate(lottoTotalProfitRate)
    }
}