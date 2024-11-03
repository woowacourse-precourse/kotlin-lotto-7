package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine

class InputView {

    fun inputAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val inputAmount = readLine()
        require(!inputAmount.isNullOrBlank()) { "[ERROR] 공백은 입력할 수 없습니다." }
        val amount = inputAmount.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 정수만 입력할 수 있습니다.")

        return amount

    }

    fun inputWinningLottoNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val winningLottoNumber = readLine().split(",").map { it.trim() }

        require(winningLottoNumber.all { it.isNotBlank() }) { "[ERROR] 공백은 입력할 수 없습니다." }
        return winningLottoNumber.map {
            it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 모든 번호는 정수여야 합니다.")
        }
    }

    fun inputBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = readLine()

        require(bonusNumber.isNotBlank()) { "[ERROR] 공백은 입력할 수 없습니다." }
        return bonusNumber.toIntOrNull() ?: throw throw IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.")
    }
}