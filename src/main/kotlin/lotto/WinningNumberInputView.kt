package lotto

import camp.nextstep.edu.missionutils.Console

class WinningNumberInputView {

    fun guideWinningNumbers() = println("당첨 번호를 입력해 주세요.")

    fun guideBonusNumber() = println("보너스 번호를 입력해 주세요.")

    fun inputWinningNumbers() = Console.readLine()

    fun inputBonusNumber() = Console.readLine()
}