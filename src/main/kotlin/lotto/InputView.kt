package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getPrice(): Int {
        while (true) {
            val input = Console.readLine()
            ExceptionProcess.validPrice(input)
            return input.toInt()
        }
    }

    fun getLottoNumber(): List<Int> {
        while (true) {
            val input = Console.readLine()
            ExceptionProcess.validLottoNumber(input)
            return input.split(",").map { it.toInt() }
        }
    }

    fun getBonusNumber(): Int {
        while (true) {
            val input = Console.readLine()
            ExceptionProcess.validBonusNumber(input)
            return input.toInt()
        }
    }

}