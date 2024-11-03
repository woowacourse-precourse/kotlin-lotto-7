package view

import controller.Controller
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val controller = Controller()

    fun start() {
        var error = true
        while (error) {
            error = controller.buyLotto(getBills())
        }
        drawLottoNumbers()
    }

    private fun drawLottoNumbers() {
        var error = true
        while (error) {
            error = controller.checkWinNumbers(getWinNumber())
        }
        println()
        drawBonusNumber()
    }

    private fun drawBonusNumber() {
        var error = true
        while (error) {
            error = controller.checkBonusNumbers(getBonusNumber())
        }
        println()
    }

    private fun getBills(): String {
        println(BILL_REQUIREMENT)
        val bill = Console.readLine()
        return bill
    }

    private fun getWinNumber(): String {
        println(WIN_NUMBER_REQUIREMENT)
        val winNumber = Console.readLine()
        return winNumber
    }

    private fun getBonusNumber(): String {
        println(BONUS_NUMBER_REQUIREMENT)
        val bonusNumber = Console.readLine()
        return bonusNumber
    }

    companion object {
        const val BILL_REQUIREMENT = "구입금액을 입력해 주세요."
        const val WIN_NUMBER_REQUIREMENT = "당첨 번호를 입력해 주세요."
        const val BONUS_NUMBER_REQUIREMENT = "보너스 번호를 입력해 주세요."
    }
}