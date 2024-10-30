package delegate.common

import util.Process

interface CommonErrorDelegate {
    fun isEmpty(input: String)
    fun isNumeric(input: String, process: Process)
    fun isOverFlow(input: String, process: Process)
}