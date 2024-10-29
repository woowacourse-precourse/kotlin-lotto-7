package lotto.domain

class Money(val amount: Int) {

    init {
        require(amount > 0) { ERROR_NOT_POSITIVE }
    }

    companion object {
        const val ERROR_NOT_POSITIVE = "[ERROR] 돈은 양수로 입력해야 합니다."
    }
}
