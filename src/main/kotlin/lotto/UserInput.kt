package lotto

import camp.nextstep.edu.missionutils.Console.readLine

object UserInput {

    fun requestPayment() {
        println("구입금액을 입력해 주세요.")
        getInput()
    }

    fun requestWinningNumbers() {
        println("당첨번호를 입력해 주세요.")
        getInput()
    }

    fun requestBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
        getInput()
    }

    private fun getInput(): String {
        return readLine()
    }

}

