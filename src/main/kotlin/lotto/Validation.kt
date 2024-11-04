package lotto

import camp.nextstep.edu.missionutils.Console
import kotlin.math.pow
import kotlin.math.roundToInt

class Validation() {

    fun payLottoery(): String {
        println("구입금액을 입력해주세요.")
        val payment = Console.readLine()
        return payment
    }

    fun String.validateInt():Int {
        return this.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자를 입력하세요.")
    }

    fun Int.validatePositive():Int {
        require(this > 0) {"[ERROR] 양수 숫자를 입력하세요."}
        return this
    }

    fun Int.validateDivisibleBy(divisor: Int):Int {
        require(this % divisor == 0) { "[ERROR] ${divisor}원 단위로 입력해 주세요." }
        return this
    }

    fun String.validateIntList():List <Int> {
        return this.split(',').map {
            it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.")
        }
    }

    fun List<Int>.findDuplicates(count: Int): List<Int> {
        require(this.toSet().size == count) {"[ERROR] 중복되지 않는 숫자로 입력해 주세요."}
        return this
    }

    fun List<Int>.validateCount(count: Int): List<Int> {
        require(this.size == count) { "갯수에 맞게 입력해 주세요." }
        return this
    }

    fun Int.validateRange(start: Int, end: Int): Int {
        require(this in start..end) { "1~45 내의 숫자를 입력해 주세요. $start ~ $end" }
        return this
    }

    fun List<Int>.validateRange(start: Int, end: Int): List<Int> {
        require(this.all { it in start..end }) { "1~45 내의 숫자를 입력해 주세요. $start ~ $end" }
        return this
    }

    fun Double.round(decimalPlaces: Int): Double {
        val factor = 10.0.pow(decimalPlaces)
        return (this * factor).roundToInt() / factor
    }

}