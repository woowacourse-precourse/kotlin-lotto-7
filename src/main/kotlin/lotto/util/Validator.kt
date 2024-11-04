package lotto.util

object Validator {
    /** 숫자 리스트에서 중복이 없는지 검사 한다. */
    fun isUniqueNumbers(numbers: List<Int>): Boolean {
        val uniqueNumbers = numbers.toSet()
        val isUnique = uniqueNumbers.size == numbers.size
        return isUnique
    }

    /** 로또 최대 번호를 초과 하는지 검사 한다. */
    fun validateNumberLimit(numbers: List<Int>): Boolean {
        numbers.forEach { number ->
            if (number > LottoConstants.MAX_NUMBER) {
                return false
            }
        }
        return true
    }
}