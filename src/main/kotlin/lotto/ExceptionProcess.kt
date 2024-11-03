package lotto

import lotto.Lotto.LottoErrorMessages

object ExceptionProcess {
    fun validPrice(input: String) {
        try {
            val price = input.toInt()
            require(price >= 1000) { "로또 한 개의 가격은 1000원 이상이어야 합니다" }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR]: 입력은 숫자여야 합니다")
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR]: ${e.message}")
        }
    }

    fun validLottoNumber(input: String){
        try {
            var numbers = input.split(",").map { it.toInt() }
            numbers = numbers.sorted()
            require(numbers.size == 6) { LottoErrorMessages.INVALID_SIZE }
            require(numbers.distinct().size == numbers.size) { LottoErrorMessages.DUPLICATE_NUMBERS }
            require(numbers.all { it in 1..45 }) { LottoErrorMessages.OUT_OF_RANGE }
            require(numbers == numbers.sorted()) { LottoErrorMessages.NOT_SORTED }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR]: 입력은 숫자여야 합니다")
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR]: ${e.message}")
        }
    }
}