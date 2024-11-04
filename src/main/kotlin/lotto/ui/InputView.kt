package lotto.ui

import camp.nextstep.edu.missionutils.Console

object InputView {

    private const val LOTTO_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요."
    private const val WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요."

    fun readLottoAmount(): String {
        println(LOTTO_AMOUNT_INPUT_MESSAGE)
        return Console.readLine()
    }

    fun readWinningNumbers(): String {
        println(WINNING_NUMBER_INPUT_MESSAGE)
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        println(BONUS_NUMBER_INPUT_MESSAGE)
        return Console.readLine()
    }
}