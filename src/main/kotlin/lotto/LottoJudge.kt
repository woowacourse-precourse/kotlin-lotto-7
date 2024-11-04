package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.ErrorMessage.*

class LottoJudge {
    private var winningNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = 0

    fun saveUserInput() {
        saveWinningNumbers()
        saveBonusNumber()
    }

    private fun saveWinningNumbers() {
        while (true) try {
            inputWinningNumbers()
            return
        } catch (error: IllegalArgumentException) {
            println(error.message)
        }
    }

    private fun inputWinningNumbers() {
        println(INPUT_WINNING_NUMBERS_GUIDE)
        val inputWinningNumbers = Console.readLine()
        val winningNumbers = validateWinningNumbers(inputWinningNumbers)
        setLottoWinningNumbers(winningNumbers)
    }

    private fun validateWinningNumbers(input: String): List<Int> {
        try {
            return input.split(",").map { it.toInt() }
        } catch (error: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.INPUT_WINNING_NUMBER_INVALID_INPUT_ERROR.getMessage())
        }
    }

    private fun saveBonusNumber() {
        while (true) try {
            inputBonusNumber()
            return
        } catch (error: IllegalArgumentException) {
            println(error.message)
        }
    }

    private fun inputBonusNumber() {
        println(INPUT_BONUS_NUMBERS_GUIDE)
        val inputBonusNumber = Console.readLine()
        val bonusNumber = validateBonusNumber(inputBonusNumber)
        setLottoBonusNumber(bonusNumber)
    }

    private fun validateBonusNumber(input: String): Int {
        try {
            return input.toInt()
        } catch (error: NumberFormatException) {
            throw IllegalArgumentException(lotto.ErrorMessage.INPUT_BONUS_NUMBER_INVALID_INPUT_ERROR.getMessage())
        }
    }

    fun setLottoWinningNumbers(numbers: List<Int>) {
        exceptWinningNumberCount(numbers)
        exceptWinningNumberRange(numbers)
        exceptDuplicates(numbers)
        winningNumbers = numbers
    }

    fun setLottoBonusNumber(number: Int) {
        exceptBonusNumberRange(number)
        require(!winningNumbers.contains(number)) {
            ErrorMessage.INPUT_BONUS_NUMBER_NOT_CONTAIN_WINNING_NUMBERS.getMessage()
        }
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
            throw IllegalArgumentException(INPUT_BONUS_NUMBER_OUT_OF_RANGE_ERROR.getMessage())
        }
    }

    private fun exceptDuplicates(numbers: List<Int>) {
        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException(INPUT_WINNING_NUMBER_NO_DUPLICATE.getMessage())
        }
    }

    fun printWinningStatistics(lottos: List<Lotto>) {
        println(WINNING_STATISTICS_TITLE)
        val ranks = lottos.map { it.checkRank(winningNumbers, bonusNumber) }
        val ranksCount = getRanksCount(ranks)
        printRanks(ranksCount)
        printProfitRatio(ranks, lottos.size)
    }

    private fun printRanks(ranksCount: List<Int>) {
        println("$FIFTH_RANK_TITLE $HYPHEN ${ranksCount[4]}${PIECE}")
        println("$FOURTH_RANK_TITLE $HYPHEN ${ranksCount[3]}${PIECE}")
        println("$THIRD_RANK_TITLE $HYPHEN ${ranksCount[2]}${PIECE}")
        println("$SECOND_RANK_TITLE $HYPHEN ${ranksCount[1]}${PIECE}")
        println("$FIRST_RANK_TITLE $HYPHEN ${ranksCount[0]}${PIECE}")
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
        println(PROFIT_RATIO_MESSAGE.format(profitRatio))
    }

    companion object {
        private const val INPUT_WINNING_NUMBERS_GUIDE: String = "\n당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBERS_GUIDE: String = "\n보너스 번호를 입력해 주세요."
        private const val WINNING_STATISTICS_TITLE: String = "\n당첨 통계\n---"
        private const val FIFTH_RANK_TITLE: String = "3개 일치 (5,000원)"
        private const val FOURTH_RANK_TITLE: String = "4개 일치 (50,000원)"
        private const val THIRD_RANK_TITLE: String = "5개 일치 (1,500,000원)"
        private const val SECOND_RANK_TITLE: String = "5개 일치, 보너스 볼 일치 (30,000,000원)"
        private const val FIRST_RANK_TITLE: String = "6개 일치 (2,000,000,000원)"
        private const val HYPHEN: String = "-"
        private const val PIECE: String = "개"
        private const val PROFIT_RATIO_MESSAGE: String = "총 수익률은 %.1f%%입니다."
    }
}