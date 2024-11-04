package lotto.util

import java.lang.NumberFormatException

class Validator {

    fun validateMoneyInput(money: String) {
        isNumber(money)
        isThousandUnit(money)
        isZero(money)
    }

    private fun isNumber(money: String) {
        try {
            money.toInt()
        } catch (e: NumberFormatException) {
            println("[ERROR] 입력이 숫자여야 합니다.")
            throw IllegalArgumentException("[ERROR] 돈은 숫자여야 합니다.")
        }
    }

    private fun isZero(money: String) {
        if (money.toInt() == 0) {
            println("[ERROR] 돈은 주셔야 합니다.")
            throw IllegalArgumentException("[ERROR] 돈은 주셔야 합니다.")
        }
    }

    private fun isThousandUnit(money: String) {
        if (money.toInt() % 1000 != 0) {
            println("[ERROR] 돈은 천 단위 숫자여야 합니다.")
            throw IllegalArgumentException("[ERROR] 돈은 천 단위 숫자여야 합니다.")
        }
    }

    fun validateWinningNumberInput(winningNumber: String) {
        validateLottoFormat(winningNumber)
    }

    private fun validateLottoFormat(winningNumber: String) {
        val reg = Regex("[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+")
        if (!reg.matches(winningNumber)) {
            println("[ERROR] 로또 입력 형식이 맞지 않습니다.")
            throw IllegalArgumentException("[ERROR] 로또 입력 형식이 맞지 않습니다.")
        }
    }

    fun validateBonusNumberInput(bonusNumber: String) {
        isNumber(bonusNumber)
        validateBonusNumberrange(bonusNumber)
    }

    private fun validateBonusNumberrange(bonusNumber: String) {
        if (bonusNumber.toInt() > 45 || bonusNumber.toInt() < 1) {
            println("[ERROR] 로또 번호의 범위는 1 ~ 45 입니다.")
            throw IllegalArgumentException("[ERROR] 로또 번호의 범위는 1 ~ 45 입니다.")
        }
    }
}