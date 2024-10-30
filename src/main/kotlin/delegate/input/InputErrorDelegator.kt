package delegate.input

import util.Exception
import util.isThousandUnit

class InputErrorDelegator : InputErrorDelegate {
    override fun isThousandWonUnit(input: String) {
        require(input.isThousandUnit()){
            Exception.INVALID_UNIT
        }
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}