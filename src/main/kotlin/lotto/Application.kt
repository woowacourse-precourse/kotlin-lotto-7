package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.model.Rank
import lotto.utils.Validation
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val price = inputView.readPrice().toIntOrNull() ?: throw IllegalArgumentException()
    require(price > 0)
    require(price % 1000 == 0)

    val lottoCount = price / 1000
    val lotto = mutableListOf<Lotto>()
    lotto.apply {
        repeat(lottoCount) {
            add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
        }
    }

    outputView.printLottoCount(lottoCount)
    outputView.printLotto(lotto)

    val winningNumber = inputView.readWinningNumber().split(",").mapNotNull { it.trim().toIntOrNull() }.toSet()
    require(winningNumber.size == 6)
    require(Validation.isValidRange(*winningNumber.toIntArray()))

    val bonusNumber = inputView.readBonusNumber().toIntOrNull() ?: throw IllegalArgumentException()
    require(Validation.isValidRange(bonusNumber))
    require(Validation.isNotDuplicated(winningNumber, bonusNumber))

    val rankCount = mutableMapOf<Rank, Int>()
    Rank.entries.forEach {
        rankCount[it] = 0
    }
    lotto.forEach {
        val rank = it.getRank(winningNumber, bonusNumber)
        rankCount[rank] = (rankCount[rank] ?: 0) + 1
    }

    rankCount.remove(Rank.NONE)
    outputView.printWinningStats(rankCount)

    outputView.printProfitRate(getProfitRate(rankCount, price))
}

fun getProfitRate(rankCount: Map<Rank, Int>, price: Int): String {
    var profit = 0
    rankCount.forEach { (rank, count) ->
        profit += rank.winningPrice * count
    }
    return String.format("%.1f", profit / price.toDouble() * 100)
}