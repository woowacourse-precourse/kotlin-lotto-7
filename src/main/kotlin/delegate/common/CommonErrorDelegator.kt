package delegate.common

import util.Exception
import util.Process
import util.isNumeric

class CommonErrorDelegator : CommonErrorDelegate {
    override fun isEmpty(input: String) {
        require(input.isNotEmpty()) { Exception.EMPTY_INPUT }
    }

    override fun isNumeric(input: String, process: Process) {
        val title = process.toString()
        require(input.isNumeric()) { "${title}은(는) ${Exception.INVALID_INPUT}" }
    }

}