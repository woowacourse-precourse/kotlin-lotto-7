package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.model.Rank
import lotto.utils.BonusNumber
import lotto.utils.Price
import lotto.utils.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val price = Price.validate(inputView.readPrice())
    val lottoCount = price / 1000
    val lotto = mutableListOf<Lotto>()
    lotto.apply {
        repeat(lottoCount) {
            add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
        }
    }

    outputView.printLottoCount(lottoCount)
    outputView.printLotto(lotto)

    val winningNumber = WinningNumber.validate(inputView.readWinningNumber())
    val bonusNumber = BonusNumber.validate(inputView.readBonusNumber(), winningNumber)

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