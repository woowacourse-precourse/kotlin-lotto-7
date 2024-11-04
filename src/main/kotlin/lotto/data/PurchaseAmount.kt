package lotto.data

import lotto.constants.Error.ERROR_AMOUNT_NEGATIVE_OR_ZERO
import lotto.constants.Error.ERROR_AMOUNT_NOT_INTEGER
import lotto.constants.Error.ERROR_AMOUNT_NOT_MULTIPLE_OF_TICKET_PRICE

class PurchaseAmount(private val amount: String, private val ticketPrice: Int) {
    init {
        validateAmount()
    }

    private fun validateAmount() {
        amount.toIntOrNull() ?: throw NumberFormatException(ERROR_AMOUNT_NOT_INTEGER)
        require(amount.toInt() > 0) { ERROR_AMOUNT_NEGATIVE_OR_ZERO }
        require(amount.toInt() % ticketPrice == 0) { ERROR_AMOUNT_NOT_MULTIPLE_OF_TICKET_PRICE.format(ticketPrice) }
    }

    fun getAmount(): Int = amount.toInt()
}