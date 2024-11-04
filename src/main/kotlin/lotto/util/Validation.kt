package lotto.util

import kotlin.math.pow
import kotlin.math.roundToInt

class LottoConstants {
    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val DIVISOR = 1000
        const val PRECISION = 2
    }
}

fun String.validateInt(): Int {
    return this.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자를 입력하세요.")
}

fun Int.validatePositive(): Int {
    require(this > 0) { "[ERROR] 양수 숫자를 입력하세요." }
    return this
}

fun Int.validateDivisibleBy(divisor: Int = LottoConstants.DIVISOR): Int {
    require(this % divisor == 0) { "[ERROR] ${divisor}원 단위로 입력해 주세요." }
    return this
}

fun String.validateIntList(): List<Int> {
    return this.split(',').map {
        it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.")
    }
}

fun List<Int>.findDuplicates(): List<Int> {
    val duplicates = this.groupingBy { it }.eachCount().filter { it.value > 1 }.keys
    require(duplicates.isEmpty()) { "[ERROR] 중복되지 않는 숫자로 입력해 주세요." }
    return this
}

fun List<Int>.validateCount(count: Int = LottoConstants.LOTTO_NUMBER_COUNT): List<Int> {
    require(this.size == count) { "[ERROR] 갯수에 맞게 입력해 주세요." }
    return this
}

fun Int.validateRange(start: Int = LottoConstants.MIN_LOTTO_NUMBER, end: Int = LottoConstants.MAX_LOTTO_NUMBER): Int {
    require(this in start..end) { "[ERROR] 1~45 내의 숫자를 입력해 주세요. $start ~ $end" }
    return this
}

fun List<Int>.validateRange(start: Int = LottoConstants.MIN_LOTTO_NUMBER, end: Int = LottoConstants.MAX_LOTTO_NUMBER): List<Int> {
    require(this.all { it in start..end }) { "[ERROR] 1~45 내의 숫자를 입력해 주세요. $start ~ $end" }
    return this
}

fun Double.round(decimalPlaces: Int = LottoConstants.PRECISION): Double {
    val factor = 10.0.pow(decimalPlaces)
    return (this * factor).roundToInt() / factor
}

