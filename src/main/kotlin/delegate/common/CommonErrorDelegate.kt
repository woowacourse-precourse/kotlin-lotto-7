package delegate.common

import domain.enums.Process

interface CommonErrorDelegate {
    fun isEmpty(input: String)
    fun isNumeric(input: String, process: Process)
}