package view

import controller.BillsController
import camp.nextstep.edu.missionutils.Console

class InputView {

    fun start() {
        val billsController = BillsController(getBills())
        println()
        billsController.showLotto()
    }

    private fun resume() {
        getWinNumber()
        println()
        getBonusNumber()
        println()
    }

    private fun getBills(): String {
        println(billRequirement)
        val bill = Console.readLine()
        return bill
    }

    private fun getWinNumber() {
        println(winNumberRequirement)
        val winNumber = Console.readLine()
    }

    private fun getBonusNumber() {
        println(bonusNumberRequirement)
        val bonusNumber = Console.readLine()
    }

    companion object {
        const val billRequirement = "구입금액을 입력해 주세요."
        const val winNumberRequirement = "당첨 번호를 입력해 주세요."
        const val bonusNumberRequirement = "보너스 번호를 입력해 주세요."
    }
}