package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getPriceInput(): String {
        println(PRICE_INPUT_MSG)
        return read()
    }

    fun getWinningNumbersInput(): String {
        println(WINNING_NUMBERS_INPUT_MSG)
        return read()
    }

    fun getBonusNumberInput(): String {
        println(BONUS_NUMBER_INPUT_MSG)
        return read()
    }

    private fun read(): String = Console.readLine() ?: throw IllegalArgumentException()

    fun close() = Console.close()

    companion object {
        private const val PRICE_INPUT_MSG = "구입금액을 입력해 주세요."
        private const val WINNING_NUMBERS_INPUT_MSG = "당첨 번호를 입력해 주세요."
        private const val BONUS_NUMBER_INPUT_MSG = "보너스 번호를 입력해 주세요."
    }
}