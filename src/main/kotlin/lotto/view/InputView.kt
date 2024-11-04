package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine

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
        val winningLottoNumber = readLine().split(LOTTO_NUMBER_DELIMITER).map { it.trim() }

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

    companion object {
        private const val LOTTO_AMOUNT = "구입금액"
        private const val LOTTO_NUMBER_DELIMITER = ","
        private const val WINNING_LOTTO_NUMBER = "당첨 번호"
        private const val BONUS_NUMBER = "보너스 번호"
        private const val MESSAGE_INPUT_VALUE = "%s을 입력해 주세요."

        const val ERROR_BLANK = "[ERROR] %s은 공백이 될 수 없습니다."
        const val ERROR_INTEGER = "[ERROR] %s는 정수만 입력할 수 있습니다."
    }
}