package view

import camp.nextstep.edu.missionutils.Console
import utils.validator.Validator

object InputView {
    fun getMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val inputMoney = Console.readLine()

        return Validator.validateMoney(inputMoney)
    }

    fun getWinningNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val inputWinningNumbers = Console.readLine()

        return Validator.validateWinningNumbers(inputWinningNumbers)
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        println("보너스 번호를 입력해 주세요.")
        val inputBonusNumber = Console.readLine()

        return Validator.validateBonusNumber(inputBonusNumber, winningNumbers)
    }

}