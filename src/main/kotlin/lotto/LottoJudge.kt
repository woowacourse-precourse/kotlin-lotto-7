package lotto

import lotto.ErrorMessage.*

class LottoJudge {
    var winnerNumbers: List<Int> = emptyList()
    var bonusNumber: Int = 0

    fun setLottoWinnerNumbers(numbers: List<Int>) {
        exceptWinnerNumberCount(numbers)
        exceptWinnerNumberRange(numbers)
        exceptDuplicates(numbers)
        winnerNumbers = numbers
    }

    fun setLottoBonusNumber(number: Int) {
        exceptBonusNumberRange(number)
        require(!winnerNumbers.contains(number)) { ErrorMessage.INPUT_WINNER_NUMBER_NO_DUPLICATE.getMessage() }
        bonusNumber = number
    }

    private fun exceptWinnerNumberCount(numbers: List<Int>) {
        if (numbers.size != LottoMaker.NUMBERS_COUNT) {
            throw IllegalArgumentException(INPUT_WINNER_NUMBER_COUNT_ERROR.getMessage())
        }
    }

    private fun exceptWinnerNumberRange(numbers: List<Int>) {
        if (numbers.any { it < LottoMaker.FIRST_NUMBER || it > LottoMaker.LAST_NUMBER }) {
            throw IllegalArgumentException(INPUT_WINNER_NUMBER_OUT_OF_RANGE_ERROR.getMessage())
        }
    }

    private fun exceptBonusNumberRange(number: Int) {
        if (number < LottoMaker.FIRST_NUMBER || number > LottoMaker.LAST_NUMBER ) {
            throw IllegalArgumentException(INPUT_WINNER_NUMBER_OUT_OF_RANGE_ERROR.getMessage())
        }
    }

    private fun exceptDuplicates(numbers: List<Int>) {
        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException(INPUT_WINNER_NUMBER_NO_DUPLICATE.getMessage())
        }
    }

    fun printWinningStatistics(lottos: List<Lotto>) {
        val ranks = lottos.map { it.checkRank(winnerNumbers, bonusNumber) }
        println("\n당첨 통계\n---")
        println("3개 일치 (5,000원) - ${ranks.filter { it == LottoRank.FIFTH }.size}개")
        println("4개 일치 (50,000원) - ${ranks.filter { it == LottoRank.FOURTH }.size}개")
        println("5개 일치 (1,500,000원) - ${ranks.filter { it == LottoRank.THIRD }.size}개")
        println("5개 일치, 보너스 볼 일 (30,000,000원) - ${ranks.filter { it == LottoRank.SECOND }.size}개")
        println("6개 일치 (2,000,000,000원) - ${ranks.filter { it == LottoRank.FIRST }.size}개")
    }
}