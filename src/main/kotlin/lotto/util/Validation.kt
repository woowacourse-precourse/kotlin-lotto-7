package lotto.util

import kotlin.math.pow
import kotlin.math.roundToInt

enum class LottoConstants(val value: Int) {
    LOTTO_NUMBER_COUNT(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    DIVISOR(1000),
    PRECISION(2)
}

object ErrorMessages {
    const val INVALID_NUMBER = "[ERROR] 숫자를 입력하세요."
    const val NON_POSITIVE = "[ERROR] 양수 숫자를 입력하세요."
    const val INVALID_DIVISOR = "[ERROR] %d원 단위로 입력해 주세요."
    const val INVALID_INPUT = "[ERROR] 숫자만 입력해 주세요."
    const val DUPLICATE_NUMBERS = "[ERROR] 중복되지 않는 숫자로 입력해 주세요."
    const val INVALID_COUNT = "[ERROR] 갯수에 맞게 입력해 주세요."
    const val OUT_OF_RANGE = "[ERROR] %d~%d 내의 숫자를 입력해 주세요."
}

fun String.validateInt(): Int {
    return this.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.INVALID_NUMBER)
}

fun Int.validatePositive(): Int {
    require(this > 0) { ErrorMessages.NON_POSITIVE }
    return this
}

fun Int.validateDivisibleBy(divisor: Int = LottoConstants.DIVISOR.value): Int {
    require(this % divisor == 0) { ErrorMessages.INVALID_DIVISOR.format(divisor) }
    return this
}

fun String.validateIntList(): List<Int> {
    return this.split(',').map {
        it.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.INVALID_INPUT)
    }
}

fun List<Int>.findDuplicates(): List<Int> {
    val duplicates = this.groupingBy { it }.eachCount().filter { it.value > 1 }.keys
    require(duplicates.isEmpty()) { ErrorMessages.DUPLICATE_NUMBERS }
    return this
}

fun List<Int>.validateCount(count: Int = LottoConstants.LOTTO_NUMBER_COUNT.value): List<Int> {
    require(this.size == count) { ErrorMessages.INVALID_COUNT }
    return this
}

fun Int.validateRange(start: Int = LottoConstants.MIN_LOTTO_NUMBER.value, end: Int = LottoConstants.MAX_LOTTO_NUMBER.value): Int {
    require(this in start..end) { ErrorMessages.OUT_OF_RANGE.format(start, end) }
    return this
}

fun List<Int>.validateRange(start: Int = LottoConstants.MIN_LOTTO_NUMBER.value, end: Int = LottoConstants.MAX_LOTTO_NUMBER.value): List<Int> {
    require(this.all { it in start..end }) { ErrorMessages.OUT_OF_RANGE.format(start, end) }
    return this
}

fun Double.round(decimalPlaces: Int = LottoConstants.PRECISION.value): Double {
    val factor = 10.0.pow(decimalPlaces)
    return (this * factor).roundToInt() / factor
}