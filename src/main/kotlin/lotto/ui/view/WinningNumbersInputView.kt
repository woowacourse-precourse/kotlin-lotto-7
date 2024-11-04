package lotto.ui.view

import camp.nextstep.edu.missionutils.Console

class WinningNumbersInputView {

    fun guideWinningNumbers() = println(INPUT_WINNING_NUMBERS_MESSAGE)

    fun guideBonusNumber() = println(INPUT_BONUS_NUMBER_MESSAGE)

    fun inputWinningNumbers() = Console.readLine()

    fun inputBonusNumber() = Console.readLine()

    companion object {
        private const val INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
    }
}