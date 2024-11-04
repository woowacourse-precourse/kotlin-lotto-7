package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getPurchaseAmount(): Int {
        return tryGetInput("구입금액을 입력해 주세요.") { Validator.validatePurchaseAmount(it) }
    }

    fun getLottoNumbers(): List<Int> {
        return tryGetInput("\n당첨 번호를 입력해 주세요.") { Validator.validateLottoNumbers(it) }
    }

    fun getBonusNumber(): Int {
        return tryGetInput("\n보너스 번호를 입력해 주세요.") { Validator.validateBonusNumber(it) }
    }

    private fun <T> tryGetInput(message: String, validator: (String) -> T): T {
        while (true) {
            println(message)
            val input = Console.readLine()
            try {
                return validator(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}