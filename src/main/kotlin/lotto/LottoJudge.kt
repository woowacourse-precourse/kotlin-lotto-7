package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.ErrorMessage.*

class LottoJudge {
    private var winningNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = 0

    fun saveUserInput() {
        inputWinningNumbers()
        inputBonusNumber()
    }

    private fun inputWinningNumbers() {
        println("\n당첨 번호를 입력해 주세요.")
        val inputWinningNumbers = Console.readLine().split(",").map { it.toInt() }
        setLottoWinningNumbers(inputWinningNumbers)
    }

    private fun inputBonusNumber() {
        println("\n보너스 번호를 입력해 주세요.")
        val inputBonusNumber = Console.readLine().toInt()
        setLottoBonusNumber(inputBonusNumber)
    }

    fun setLottoWinningNumbers(numbers: List<Int>) {
        exceptWinningNumberCount(numbers)
        exceptWinningNumberRange(numbers)
        exceptDuplicates(numbers)
        winningNumbers = numbers
    }

    fun setLottoBonusNumber(number: Int) {
        exceptBonusNumberRange(number)
        require(!winningNumbers.contains(number)) { ErrorMessage.INPUT_WINNING_NUMBER_NO_DUPLICATE.getMessage() }
        bonusNumber = number
    }

    private fun exceptWinningNumberCount(numbers: List<Int>) {
        if (numbers.size != LottoMaker.NUMBERS_COUNT) {
            throw IllegalArgumentException(INPUT_WINNING_NUMBER_COUNT_ERROR.getMessage())
        }
    }

    private fun exceptWinningNumberRange(numbers: List<Int>) {
        if (numbers.any { it < LottoMaker.FIRST_NUMBER || it > LottoMaker.LAST_NUMBER }) {
            throw IllegalArgumentException(INPUT_WINNING_NUMBER_OUT_OF_RANGE_ERROR.getMessage())
        }
    }

    private fun exceptBonusNumberRange(number: Int) {
        if (number < LottoMaker.FIRST_NUMBER || number > LottoMaker.LAST_NUMBER ) {
            throw IllegalArgumentException(INPUT_WINNING_NUMBER_OUT_OF_RANGE_ERROR.getMessage())
        }
    }

    private fun exceptDuplicates(numbers: List<Int>) {
        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException(INPUT_WINNING_NUMBER_NO_DUPLICATE.getMessage())
        }
    }

    fun printWinningStatistics(lottos: List<Lotto>) {
        println("\n당첨 통계\n---")
        val ranks = lottos.map { it.checkRank(winningNumbers, bonusNumber) }
        val ranksCount = getRanksCount(ranks)
        printRanks(ranksCount)
        printProfitRatio(ranks, lottos.size)
    }

    private fun printRanks(ranksCount: List<Int>) {
        println("3개 일치 (5,000원) - ${ranksCount[4]}개")
        println("4개 일치 (50,000원) - ${ranksCount[3]}개")
        println("5개 일치 (1,500,000원) - ${ranksCount[2]}개")
        println("5개 일치, 보너스 볼 일 (30,000,000원) - ${ranksCount[1]}개")
        println("6개 일치 (2,000,000,000원) - ${ranksCount[0]}개")
    }

    private fun getRanksCount(ranks: List<LottoRank>): List<Int> {
        return listOf(
            ranks.filter { it == LottoRank.FIRST }.size,
            ranks.filter { it == LottoRank.SECOND }.size,
            ranks.filter { it == LottoRank.THIRD }.size,
            ranks.filter { it == LottoRank.FOURTH }.size,
            ranks.filter { it == LottoRank.FIFTH }.size
        )
    }

    private fun printProfitRatio(ranks: List<LottoRank>, lottoCount: Int) {
        val totalPrizeMoney = ranks.fold(0) { accumulatedValue, rank -> accumulatedValue + rank.prizeMoney }
        val profitRatio = totalPrizeMoney / (lottoCount * 1000.0) * 100
        println("총 수익률은 %.1f%%입니다.".format(profitRatio))
    }
}