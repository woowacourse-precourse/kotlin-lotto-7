package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoOperator
import lotto.domain.LottoResult
import lotto.domain.ReturnRateCalculator

class ViewModel {
    private var cost: Long? = null
    var winningLottos: List<Lotto>? = null
    lateinit var userLottoNumbers: List<Int>
    var bonusNumber: Int? = null
    val lottoResults: List<LottoResult>
        get() = LottoOperator(
            winningLottos ?: throw IllegalStateException("winningLottos is not initialized"),
            Lotto(userLottoNumbers),
            bonusNumber ?: throw IllegalStateException("bonusNumber is not initialized")
        ).checkLotteryResult()
    private val profit: Long get() = lottoResults.sumOf { lotteryResult -> lotteryResult.prize }
    val returnRate: Double
        get() = ReturnRateCalculator.calculate(
            cost ?: throw IllegalStateException("winningLottos is not initialized"), profit
        )

    fun buyLottos(cost: Long) {
        this.cost = cost
        winningLottos = LottoOperator.buy(cost)
    }
}