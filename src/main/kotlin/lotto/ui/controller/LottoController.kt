package lotto.ui.controller

import lotto.domain.entity.User
import lotto.domain.entity.Lotto
import lotto.domain.entity.WinningNumbers
import lotto.domain.usecase.CalculateLottoRankUseCase
import lotto.domain.usecase.CalculateLottoReturnUseCase
import lotto.domain.usecase.CreateUserUseCase
import lotto.domain.usecase.CreateWinningNumbersUseCase
import lotto.ui.view.LottoBuyView
import lotto.ui.view.LottoResultView
import lotto.ui.view.WinningNumberInputView

class LottoController(
    private val calculateLottoRankUseCase: CalculateLottoRankUseCase,
    private val calculateLottoReturnUseCase: CalculateLottoReturnUseCase,
    private val createUserUseCase: CreateUserUseCase,
    private val createWinningNumbersUseCase: CreateWinningNumbersUseCase,
    private val lottoBuyView: LottoBuyView,
    private val winningNumberInputView: WinningNumberInputView,
    private val lottoResultView: LottoResultView
) {
    fun run() {
        val user = getUser()
        showLottoTicketsResult(user)
        val winningNumbers = getWinningNumbers()
        showLottoResult(user.getLottoTickets(), winningNumbers)
    }

    private fun getUser(): User {
        lottoBuyView.guidePurchaseAmount()
        return createUserUseCase.execute { lottoBuyView.inputPurchaseAmount() }
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
        val bonusNumber = {
            winningNumberInputView.guideBonusNumber()
            winningNumberInputView.inputBonusNumber()
        }
        return createWinningNumbersUseCase.execute(winningNumbers, bonusNumber)
    }

    private fun showLottoResult(lottoTickets: List<Lotto>, winningNumbers: WinningNumbers) {
        val lottoTicketsRank = lottoTickets.map { lotto ->
            calculateLottoRankUseCase.execute(lotto, winningNumbers)
        }
        lottoResultView.outputWinningStatistics(lottoTicketsRank)
        val winningPrizes = lottoTicketsRank.map { it.price }
        val lottoTotalProfitRate = calculateLottoReturnUseCase.execute(winningPrizes, lottoTickets.size.times(1000))
        lottoResultView.outputTotalProfitRate(lottoTotalProfitRate)
    }
}