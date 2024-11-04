package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.constants.ErrorMessages.ERROR_BLANK
import lotto.constants.ErrorMessages.ERROR_INTEGER
import lotto.constants.LottoMessages.BONUS_NUMBER
import lotto.constants.LottoMessages.MESSAGE_INPUT_VALUE
import lotto.constants.LottoMessages.LOTTO_AMOUNT
import lotto.constants.LottoMessages.WINNING_LOTTO_NUMBER

class InputView {

    fun inputAmount(): Int {
        println(MESSAGE_INPUT_VALUE.format(LOTTO_AMOUNT))
        val inputAmount = readLine()

        require(!inputAmount.isNullOrBlank()) { ERROR_BLANK.format(LOTTO_AMOUNT) }
        val amount = inputAmount.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INTEGER.format(LOTTO_AMOUNT))

        return amount
    }

    fun inputWinningLottoNumber(): List<Int> {
        println()
        println(MESSAGE_INPUT_VALUE.format(WINNING_LOTTO_NUMBER))
        val winningLottoNumber = readLine().split(",").map { it.trim() }

        require(winningLottoNumber.all { it.isNotBlank() }) { ERROR_BLANK.format(WINNING_LOTTO_NUMBER) }

        return winningLottoNumber.map {
            it.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INTEGER.format(WINNING_LOTTO_NUMBER))
        }
    }

    fun inputBonusNumber(): Int {
        println()
        println(MESSAGE_INPUT_VALUE.format(BONUS_NUMBER))
        val bonusNumber = readLine()

        require(bonusNumber.isNotBlank()) { ERROR_BLANK.format(BONUS_NUMBER) }

        return bonusNumber.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INTEGER.format(BONUS_NUMBER))
    }
}