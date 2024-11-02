package domain.validator.delegate.input

import domain.enums.Process

interface InputErrorDelegate {
    fun isThousandWonUnit(input: String)
    fun isOverMaxPrice(input: String)
    fun isExceededRange(input: List<String>, process: Process)
    fun isInvalidInputFormat(input: String)
    fun isInvalidLottoSize(input: List<String>)
    fun isDuplicated(input: Map<String, Int>)
}