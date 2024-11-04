package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.util.ErrorMessages
import lotto.util.InputValidate

class InputView {
    fun getPrice(): Int {
        println("구입금액을 입력해 주세요.")
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

    fun getLottoNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        while (true) {
            try {
                val input = Console.readLine()
                val lottoNumber = input.split(",").map { it.trim().toIntOrNull() }
                InputValidate.checkMyLotto(input, lottoNumber)

                val notNullLottoNumber: List<Int> = lottoNumber.filterNotNull().sorted()
                return notNullLottoNumber
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    fun getBonusNumber(myLotto: Lotto): Int {
        println("보너스 번호를 입력해 주세요.")
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
}