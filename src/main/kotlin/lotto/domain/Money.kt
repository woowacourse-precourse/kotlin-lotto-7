package lotto.domain

import lotto.constant.ExceptionMessage.ERROR_NOT_POSITIVE

open class Money(val amount: Int) {

    init {
        require(amount > 0) { ERROR_NOT_POSITIVE }
    }
}
