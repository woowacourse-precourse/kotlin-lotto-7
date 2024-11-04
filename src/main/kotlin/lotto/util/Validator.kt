package lotto.util

import java.lang.NumberFormatException

class Validator {

    fun validateMoneyInput(money: String){
        isNumber(money)
        isThousandUnit(money)
        isZero(money)
    }

    private fun isNumber(money:String){
        try {
            money.toInt()
        }catch (e: NumberFormatException){
            println("[ERROR] 돈은 숫자여야 합니다.")
            throw IllegalArgumentException("[ERROR] 돈은 숫자여야 합니다.")
        }
    }

    private fun isZero(money:String){

        if (money.toInt() == 0) {
            println("[ERROR] 돈은 주셔야 합니다.")
            throw IllegalArgumentException("[ERROR] 돈은 주셔야 합니다.")
        }
    }

    private fun isThousandUnit(money:String){
        if (money.toInt() % 1000 != 0) {
            println("[ERROR] 돈은 천 단위 숫자여야 합니다.")
            throw IllegalArgumentException("[ERROR] 돈은 천 단위 숫자여야 합니다.")
        }
    }
}