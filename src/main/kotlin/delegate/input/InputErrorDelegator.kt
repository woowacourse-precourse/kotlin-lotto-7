package delegate.input

import domain.enums.Exception
import domain.enums.Process
import util.isThousandUnit

class InputErrorDelegator : InputErrorDelegate {
    override fun isThousandWonUnit(input: String) {
        require(input.isThousandUnit()) {
            Exception.INVALID_UNIT
        }
    }

    override fun isExceededRange(input: List<String>, process: Process) {
        input.forEach {
            require(it.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
                Exception.EXCEED_INPUT
            }
        }
    }

    override fun isInvalidInputFormat(input: String) {
        require(input.matches(REGEX.toRegex())) { Exception.INVALID_FORMAT }
    }

    override fun isInvalidLottoSize(input: List<String>) {
        require(input.size == LOTTO_SIZE) { Exception.INVALID_SIZE }
    }

    override fun isDuplicated(input: Map<String, Int>) {
        require(input.count{ it.value > 1 } == 0) { Exception.INVALID_DUPLICATED }
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_SIZE = 6
        const val REGEX = "^[0-9,]+$"
    }
}