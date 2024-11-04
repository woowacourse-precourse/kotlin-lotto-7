package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.util.ErrorMessages

class InputView {
    fun getPrice(): Int {
        println("구입금액을 입력해 주세요.")
        while (true) {
            val input = Console.readLine()
            try {
                val price = input.toIntOrNull()

                require(input != "") { ErrorMessages.NULL_PRICE }
                require(price != null) { ErrorMessages.NOT_INT }
                require(price >= 1000) { ErrorMessages.MINIMUM_PRICE }
                return price
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

                require(input != "") { ErrorMessages.NULL_LOTTO_NUMBER }
                require(lottoNumber.all { it != null }) { ErrorMessages.NOT_INT }
                require(lottoNumber.all { it in 1..45 }) { ErrorMessages.OUT_OF_RANGE }
                require(lottoNumber.size == 6) { ErrorMessages.INVALID_NUMBER_SIZE }
                require(lottoNumber.distinct().size == lottoNumber.size) { ErrorMessages.DUPLICATE_NUMBERS }
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

                require(input != "") { ErrorMessages.NULL_BONUS_NUMBER }
                require(bonusNumber != null) { ErrorMessages.NOT_INT }
                require(bonusNumber in 1..45) { ErrorMessages.OUT_OF_RANGE }
                require(bonusNumber !in myLotto.getNumbers()) { ErrorMessages.DUPLICATED_BONUS }

                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}