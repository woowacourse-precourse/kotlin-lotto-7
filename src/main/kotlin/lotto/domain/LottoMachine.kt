package lotto.domain

import lotto.data.*
import lotto.ui.InputView
import lotto.ui.OutputView

class LottoMachine(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun start() {
        val client = buildClient()
        printLottoQuantity(client.lottoNumbers)
        printLottoNumbers(client.lottoNumbers)
        val winning = buildWinning()
        val bonus = buildBonus(winning)
        val winningResult = WinningResult(client.lottoNumbers, winning.numbers, bonus.number)
        val sortWinningDetails = winningDetailsSort(winningResult.details)
        printWinningDetails(sortWinningDetails)
        printProfitRate(winningResult.profitRate)
    }

    private fun buildClient(): Client {
        return try {
            Client(inputView.readLottoAmount())
        } catch (e: IllegalArgumentException) {
            printErrorCauseMessage(e.message)
            buildClient()
        }
    }

    private fun printLottoQuantity(numbers: List<List<Int>>) {
        outputView.printNewLine()
        outputView.printLottoQuantity(numbers.size)
    }

    private fun printLottoNumbers(lottoNumbers: List<List<Int>>) {
        for (lottoNumber in lottoNumbers) {
            outputView.printLottoNumber(lottoNumber)
        }
    }

    private fun buildWinning(): Winning {
        return try {
            outputView.printNewLine()
            Winning(inputView.readWinningNumbers())
        } catch (e: IllegalArgumentException) {
            printErrorCauseMessage(e.message)
            buildWinning()
        }
    }

    private fun buildBonus(winning: Winning): Bonus {
        return try {
            outputView.printNewLine()
            Bonus(inputView.readBonusNumber(), winning.numbers)
        } catch (e: IllegalArgumentException) {
            printErrorCauseMessage(e.message)
            buildBonus(winning)
        }
    }

    private fun winningDetailsSort(details: Map<Rank, Int>): Map<Rank, Int> {
        return details.toSortedMap { o1, o2 -> o1.winningPrize.compareTo(o2.winningPrize) }
    }

    private fun printWinningDetails(details: Map<Rank, Int>) {
        outputView.printNewLine()
        outputView.printWinningDetailHead()
        details.forEach { detail ->
            printWinningDetail(detail)
        }
    }

    private fun printWinningDetail(detail: Map.Entry<Rank, Int>) {
        val countOfMatch = detail.key.countOfMatch
        outputView.printMatchesNumbers(countOfMatch)
        if (detail.key == Rank.SECOND) outputView.printWinningBonusMatch()
        val winningPrize = detail.key.winningPrize
        outputView.printWinningPrize(winningPrize)
        outputView.printWinningDivider()
        val winningCount = detail.value
        outputView.printWinningCount(winningCount)
    }

    private fun printProfitRate(profitRate: Double) = outputView.printProfitRate(profitRate)

    private fun printErrorCauseMessage(message: String?) {
        message?.let { outputView.printErrorCauseMessage(it) }
            ?: outputView.printOtherErrorMessage()
    }
}