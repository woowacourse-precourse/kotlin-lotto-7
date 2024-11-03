package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoOperator
import lotto.domain.LottoResult
import lotto.domain.ReturnRateCalculator

class ViewModel {
    var cost: Long? = null
    val winningLottos: List<Lotto> = LottoOperator.buy(cost ?: throw IllegalStateException("cost is not initialized"))
    private lateinit var purchasedLotto: Lotto
    private var bonusNumber: Int? = null
    private val lottoOperator: LottoOperator = LottoOperator(
        winningLottos, purchasedLotto, bonusNumber ?: throw IllegalStateException("bonusNumber is not initialized")
    )
    private val lotteryResults: List<LottoResult> = lottoOperator.checkLotteryResult()
    private val profit: Long = lotteryResults.sumOf { lotteryResult -> lotteryResult.prize }
    val returnRate: Double =
        ReturnRateCalculator.calculate(cost ?: throw IllegalStateException("winningLottos is not initialized"), profit)

    fun setUserLotto(purchasedNumbers: List<Int>, bonusNumber: Int) {
        purchasedLotto = Lotto(purchasedNumbers)
        this.bonusNumber = bonusNumber
    }
}