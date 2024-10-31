package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Constants

class InputView {
    fun getLottoAmount(): Int {
        while (true) {
            println(Constants.INPUT_BUY_AMOUNT_MESSAGE)
            val input = Console.readLine()
            try {
                validateLottoAmount(input)
                println()
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getWinningNumbers(): List<Int> {
        while (true) {
            println(Constants.INPUT_WINNING_NUMBERS_MESSAGE)
            val winningNumbers = Console.readLine().split(",")
            try {
                validateWinningNumbers(winningNumbers)
                println()
                return winningNumbers.map { it.toInt() }
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println(Constants.INPUT_BONUS_NUMBER_MESSAGE)
            val bonusNumber = Console.readLine()
            try {
                validateBonusNumber(bonusNumber, winningNumbers)
                println()
                return bonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validateLottoAmount(lottoAmount: String) {
        require(lottoAmount.toIntOrNull() != null) { Constants.ERROR_AMOUNT_NOT_NUMBER }
        val amount = lottoAmount.toInt()
        require(amount > 0) { Constants.ERROR_AMOUNT_NOT_POSITIVE }
        require(amount % 1000 == 0) { Constants.ERROR_AMOUNT_NOT_DIVIDE_BY_1000 }
    }

    private fun validateWinningNumbers(winningNumbers: List<String>) {
        require(winningNumbers.all { it.toIntOrNull() != null }) {
            Constants.ERROR_WINNING_NUMBERS_NOT_NUMBER
        }
        require(winningNumbers.size == 6) {
            Constants.ERROR_WINNING_NUMBERS_INCORRECT_SIZE
        }
        require(winningNumbers.all { it.toInt() in 1..45 }) {
            Constants.ERROR_WINNING_NUMBERS_OUT_OF_RANGE
        }
        require(winningNumbers.distinct().size == winningNumbers.size) {
            Constants.ERROR_WINNING_NUMBERS_DUPLICATE
        }
    }

    private fun validateBonusNumber(bonusNumber: String, winningNumbers: List<Int>) {
        require(bonusNumber.toIntOrNull() != null) { Constants.ERROR_BONUS_NUMBER_NOT_NUMBER }
        require(bonusNumber.toInt() in 1..45) { Constants.ERROR_BONUS_NUMBER_OUT_OF_RANGE }
        require(bonusNumber.toInt() !in winningNumbers) { Constants.ERROR_BONUS_NUMBER_DUPLICATE }
    }
}