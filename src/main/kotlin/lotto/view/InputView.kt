package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.util.ErrorMessages
import lotto.util.InputValidate

class InputView {
    fun getPrice(): Int {
        println(GET_PRICE)
        while (true) {
            val input = Console.readLine()
            try {
                val price = input.toIntOrNull()
                InputValidate.checkPrice(input, price)
                return price ?: 0
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getMyLotto(): Lotto {
        println(GET_MY_LOTTO)
        while (true) {
            try {
                val input = Console.readLine()
                require(input != "") { ErrorMessages.NULL_LOTTO_NUMBER }

                val lottoNumber = input.split(",").map { it.trim().toIntOrNull() }
                val notNullLottoNumber: List<Int> = lottoNumber.filterNotNull().sorted()
                require(lottoNumber.all { it != null }) { ErrorMessages.NOT_INT }

                return Lotto(notNullLottoNumber)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumber(myLotto: Lotto): Int {
        println(GET_BONUS_NUMBER)
        while (true) {
            try {
                val input = Console.readLine()
                val bonusNumber = input.toIntOrNull()

                InputValidate.checkMyBonus(input, bonusNumber, myLotto)

                return bonusNumber ?: 0
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    companion object{
        const val GET_PRICE = "구입금액을 입력해 주세요."
        const val GET_MY_LOTTO = "당첨 번호를 입력해 주세요."
        const val GET_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    }
}