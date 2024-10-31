package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Rank
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {
    fun run() {
        val purchaseAmount = getValidPurchaseAmount()
        val lottoCount = purchaseAmount / 1_000
        val lottos = generateLottos(lottoCount)
        val winningLotto = getVaildWinningLotto()
        val result = calculateResult(lottos, winningLotto)
        OutputView.printPurchasedLottos(lottos)
        OutputView.printResult(result, purchaseAmount)
    }

    private fun getValidPurchaseAmount(): Int {
        while (true) {
            try {
                val amount = InputView.getPurchaseAmount()
                require(amount % 1_000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
                return amount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
    private fun generateLottos(count: Int): List<Lotto> {
        return List(count) { Lotto() }
    }

    private fun getVaildWinningLotto() : WinningLotto {
        while (true) {
            try {
                val winningNumbers = InputView.getWinningNumbers()
                val bonusNumber = InputView.getBonusNumbers()
                return WinningLotto(winningNumbers, bonusNumber)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
    private fun calculateResult(lottos: List<Lotto>, winningLotto: WinningLotto): LottoResult {
        val rankCounts = mutableMapOf<Rank, Int>()
        lottos.forEach { lotto ->
            val matchCount =
                lotto.getNumbers().count { winningLotto.getWinningNumbers().contains(it) }
            val matchBonus = lotto.getNumbers().contains(winningLotto.getBonusNumber())
            val rank = Rank.valueOfMatchCount(matchCount, matchBonus)
            rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1
        }
        return LottoResult(rankCounts)
    }

}