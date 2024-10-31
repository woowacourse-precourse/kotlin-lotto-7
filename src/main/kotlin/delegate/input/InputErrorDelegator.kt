package delegate.input

import domain.enums.Exception
import util.isThousandUnit

class InputErrorDelegator : InputErrorDelegate {
    override fun isThousandWonUnit(input: String) {
        require(input.isThousandUnit()){
            Exception.INVALID_UNIT
        }
    }

    override fun isInvalidLottoSize(input: List<String>) {
        require(input.size == LOTTO_SIZE) { Exception.INVALID_SIZE }
    }


    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_SIZE = 6
    }
}