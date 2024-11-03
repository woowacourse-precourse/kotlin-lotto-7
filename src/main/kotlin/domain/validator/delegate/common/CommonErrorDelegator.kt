package domain.validator.delegate.common

import domain.enums.Exception
import domain.enums.Process
import domain.util.ext.isNumeric

class CommonErrorDelegator : CommonErrorDelegate {
    override fun isEmpty(input: String) {
        require(input.trim().isNotEmpty()) { Exception.EMPTY_INPUT }
    }

    override fun isOverIntMaxValue(input: String) {
        require(input.toIntOrNull() != null) { Exception.EXCEED_MAX_INT }
    }

    override fun isNumeric(input: String, process: Process) {
        val title = process.toString()
        require(input.isNumeric()) { "${title}은(는) ${Exception.INVALID_INPUT}" }
    }
}