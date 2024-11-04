package lotto.domain.validator.delegate.input

import lotto.domain.enums.Process

interface InputErrorDelegate {
    fun isThousandWonUnit(input: String)
    fun isExceededRange(input: List<String>, process: Process)
    fun isInvalidInputFormat(input: String)
    fun isInvalidLottoSize(input: List<String>)
    fun isDuplicated(input: Map<String, Int>)
    fun isDuplicatedBonusNumber(winningNumber: List<Int>, bonusNumber: Int)
}