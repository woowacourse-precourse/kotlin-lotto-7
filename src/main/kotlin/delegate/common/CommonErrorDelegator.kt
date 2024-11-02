package delegate.common

import domain.enums.Exception
import domain.enums.Process
import util.ext.isNumeric

class CommonErrorDelegator : CommonErrorDelegate {
    override fun isEmpty(input: String) {
        require(input.isNotEmpty()) { Exception.EMPTY_INPUT }
    }

    override fun isNumeric(input: String, process: Process) {
        val title = process.toString()
        require(input.isNumeric()) { "${title}은(는) ${Exception.INVALID_INPUT}" }
    }
}