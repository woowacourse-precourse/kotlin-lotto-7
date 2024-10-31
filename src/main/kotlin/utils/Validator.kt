package utils

import utils.ExtensionUtil.getInt

object Validator {

    fun validateMoney(inputMoney: String) {

        val money = inputMoney.getInt() ?: throw IllegalArgumentException("금액은 숫자로 입력해야 합니다.")

        require(money >= 0) { "금액은 양수로 입력해야 합니다." }

        require(money % 1000 == 0) { "금액은 1,000원 단위로 입력해야 합니다." }
    }


}