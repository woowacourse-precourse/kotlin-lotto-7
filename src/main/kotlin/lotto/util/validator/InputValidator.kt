package lotto.util.validator

object InputValidator {
    /** 숫자 인지 검사 한다. */
    fun isNumber(input: String): Boolean = input.toIntOrNull() != null

    /** 비어 있는지 검사 한다. */
    fun isNotEmpty(input: String): Boolean = input.isNotEmpty()

    /** 쉼표로 구분 했는지 검사 한다. */
    fun isDelimiterValid(input: String, delimiter: Char): Boolean {
        return input.split(delimiter)
            .all {
                it.trim().toIntOrNull() != null
            }
    }

    /** 로또 번호와 보너스 번호가 중복 되지 않는지 검사 한다. */
    fun isBonusNumberUnique(
        numbers: List<Int>,
        bonusNumber: Int,
    ): Boolean = !numbers.contains(bonusNumber)
}