package delegate.input

import domain.enums.Exception
import domain.enums.LottoSetting.LOTTO_MIN
import domain.enums.LottoSetting.LOTTO_MAX
import domain.enums.LottoSetting.LOTTO_SIZE
import domain.enums.Process
import util.ext.isThousandUnit

class InputErrorDelegator : InputErrorDelegate {
    override fun isThousandWonUnit(input: String) {
        require(input.isThousandUnit()) {
            Exception.INVALID_UNIT
        }
    }

    override fun isExceededRange(input: List<String>, process: Process) {
        input.forEach {
            require(it.toInt() in LOTTO_MIN.value()..LOTTO_MAX.value()) {
                Exception.EXCEED_INPUT
            }
        }
    }

    override fun isInvalidInputFormat(input: String) {
        require(input.matches(REGEX.toRegex())) { Exception.INVALID_FORMAT }
    }

    override fun isInvalidLottoSize(input: List<String>) {
        require(input.size == LOTTO_SIZE.value()) { Exception.INVALID_SIZE }
    }

    override fun isDuplicated(input: Map<String, Int>) {
        require(input.count{ it.value > 1 } == 0) { Exception.INVALID_DUPLICATED }
    }

    companion object {
        const val REGEX = "^[0-9,]+$"
    }
}