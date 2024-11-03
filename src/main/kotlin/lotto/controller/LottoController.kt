package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Rank
import lotto.domain.WinningLotto
import lotto.util.Constants
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {
    // 로또 실행
    fun run() {
        val purchaseAmount = getValidPurchaseAmount()
        val winningLotto = getValidWinningLotto()
        val lottoTickets = generateLottos(purchaseAmount)
        OutputView.printPurchasedLottos(lottoTickets)
        val lottoResult = calculateResult(lottoTickets, winningLotto)
        OutputView.printResult(lottoResult, purchaseAmount)
    }

    // 금액 입력
    private fun getValidPurchaseAmount(): Int {
        while (true) {
            try {
                val amount = InputView.readPurchaseAmount()
                validatePurchaseAmount(amount)
                return amount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    // 유효성 검증
    private fun validatePurchaseAmount(amount: Int) {
        if (amount < Constants.LOTTO_PRICE || amount % Constants.LOTTO_PRICE != 0) {
            throw IllegalArgumentException(Constants.ERROR_INVALID_PURCHASE_AMOUNT)
        }
    }

    // 로또 발행
    private fun generateLottos(purchaseAmount: Int): List<Lotto> {
        val count = purchaseAmount / Constants.LOTTO_PRICE
        return List(count) { Lotto() }
    }

    // 당첨 로또 입력
    private fun getValidWinningLotto(): WinningLotto {
        while (true) {
            try {
                val winningNumbers = InputView.readWinningNumbers()
                val bonusNumber = InputView.readBonusNumber()
                return WinningLotto(winningNumbers, bonusNumber)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    // 당첨 결과 계산
    private fun calculateResult(lottoTickets: List<Lotto>, winningLotto: WinningLotto): LottoResult {
        val rankCounts = mutableMapOf<Rank, Int>()
        lottoTickets.forEach { lotto ->
            val rank = getRank(lotto, winningLotto)
            rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1
        }
        return LottoResult(rankCounts)
    }

    // 로또 등수 계산
    private fun getRank(lotto: Lotto, winningLotto: WinningLotto): Rank {
        val matchCount = lotto.getNumbers().count { it in winningLotto.getWinningNumbers() }
        val matchBonus = lotto.getNumbers().contains(winningLotto.getBonusNumber())
        return Rank.findBy(matchCount, matchBonus)
    }
}