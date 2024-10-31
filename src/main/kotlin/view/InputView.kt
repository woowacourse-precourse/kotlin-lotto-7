package view

import camp.nextstep.edu.missionutils.Console
import utils.validator.Validator

object InputView {
    fun getMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val inputMoney = Console.readLine()

        return Validator.validateMoney(inputMoney)
    }
}