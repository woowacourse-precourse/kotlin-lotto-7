package lotto

class LottoController(
    private val calculateLottoRankUseCase: CalculateLottoRankUseCase,
    private val calculateLottoReturnUseCase: CalculateLottoReturnUseCase,
    private val lottoBuyView: LottoBuyView,
    private val winningNumberInputView: WinningNumberInputView,
    private val lottoResultView: LottoResultView
) {
    fun run() {
        val lottoCost = getLottoCost()
        val user = User(lottoCost.toInt())
        showLottoTicketsResult(user)
        val winningNumbers = getWinningNumbers()
        showLottoResult(user.getLottoTickets(), winningNumbers)
    }

    private fun getLottoCost(): Int {
        lottoBuyView.guidePurchaseAmount()
        return parseLottoCost()
    }

    private fun parseLottoCost(): Int {
        while (true) {
            try {
                val input = lottoBuyView.inputPurchaseAmount()
                return input.toInt()
            } catch (e: NumberFormatException) {
                println("[ERROR] 숫자만 입력해주세요.")
            }
        }
    }

    private fun showLottoTicketsResult(user: User) {
        lottoBuyView.guidePurchaseLottoCount(user.getLottoTickets().count())
        lottoBuyView.guideLottoNumbers(user.getLottoTickets())
    }

    private fun getWinningNumbers(): WinningNumbers {
        val winningNumbers = parserWinningNumbers()
        val bonusNumber = parserBonusNumbers()
        return WinningNumbers(winningNumbers, bonusNumber)
    }

    private fun parserWinningNumbers(): List<Int> {
        while (true) {
            try {
                val input = winningNumberInputView.inputWinningNumbers().split(",").map { it.toInt() }
                return input
            } catch (e: NumberFormatException) {
                println("[ERROR] 숫자만 입력해주세요.")
            }
        }
    }

    private fun parserBonusNumbers(): Int {
        while (true) {
            try {
                val input = winningNumberInputView.inputBonusNumber().toInt()
                return input
            } catch (e: NumberFormatException) {
                println("[ERROR] 숫자만 입력해주세요.")
            }
        }
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