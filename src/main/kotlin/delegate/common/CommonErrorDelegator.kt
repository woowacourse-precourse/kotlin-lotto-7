package delegate.common

import util.Exception

class CommonErrorDelegator: CommonErrorDelegate {
    override fun isEmpty(input: String) {
        require(input.isNotEmpty()){ Exception.EMPTY_INPUT }
    }
}