package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoWinningInfo
import lotto.domain.Money
import lotto.dto.LottoStatistics

const val MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
const val MESSAGE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
const val MESSAGE_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
const val MESSAGE_OUTPUT_LOTTO_COUNT = "%d개를 구매했습니다."
const val MESSAGE_STATISTICS_TITLE = "당첨 통계\n---"
const val MESSAGE_DEFAULT_MATCH = "%d개 일치 (%s원) - %d개"
const val MESSAGE_BONUS_MATCH = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
const val RETURN_ON_INVESTMENT = "총 수익률은 %,.1f%%입니다."

fun getLottoPurchaseAmount(): Money {
    while (true) {
        try {
            println(MESSAGE_INPUT_PURCHASE_AMOUNT)
            val input = convertInt(readLineAndLineBreak())

            return Money(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
        }
    }
}

fun getLottoWinningInfo(): LottoWinningInfo {
    val winningInfo = LottoWinningInfo(getLottoWinningNumbers())
    setLottoBonusNumber(winningInfo)

    return winningInfo
}

fun printPurchasedLottos(lottos: MutableList<Lotto>) {
    println(MESSAGE_OUTPUT_LOTTO_COUNT.format(lottos.size))
    lottos.forEach { println(it.toString()) }
    println()
}

fun printStatistics(lottoStatistics: LottoStatistics) {
    println(MESSAGE_STATISTICS_TITLE)
    println(getDefaultMatchMessage(LottoRank.FIFTH, lottoStatistics))
    println(getDefaultMatchMessage(LottoRank.FOURTH, lottoStatistics))
    println(getDefaultMatchMessage(LottoRank.THIRD, lottoStatistics))
    println(getDefaultMatchMessage(LottoRank.SECOND, lottoStatistics))
    println(getDefaultMatchMessage(LottoRank.FIRST, lottoStatistics))
    println(RETURN_ON_INVESTMENT.format(lottoStatistics.roi))
}

private fun getDefaultMatchMessage(rank: LottoRank, statistics: LottoStatistics): String {
    val rankMatchCount = rank.matchCount
    val prizeMoney = rank.prize
    val count = statistics.rankCount.getOrDefault(rank, 0)

    if (rank.bonusMatch) {
        return MESSAGE_BONUS_MATCH.format(rankMatchCount, formatWon(prizeMoney), count)
    }
    return MESSAGE_DEFAULT_MATCH.format(rankMatchCount, formatWon(prizeMoney), count)
}

private fun setLottoBonusNumber(winningInfo: LottoWinningInfo) {
    while (true) {
        try {
            println(MESSAGE_INPUT_BONUS_NUMBER)
            winningInfo.bonusNumber = convertInt(readLineAndLineBreak())
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
        }
    }
}

fun getLottoWinningNumbers(): List<Int> {
    while (true) {
        try {
            println(MESSAGE_INPUT_WINNING_NUMBER)
            val input = convertListInt(readLineAndLineBreak())

            return input
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
        }
    }
}

private fun readLineAndLineBreak(): String {
    val input = Console.readLine()
    println()

    return input
}
