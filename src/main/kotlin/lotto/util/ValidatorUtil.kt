package lotto.util

import lotto.util.ConstantsUtil.MESSAGE_BONUS_NUMBERS_NOT_INT
import lotto.util.ConstantsUtil.MESSAGE_NUMBER_SIZE_INVALID
import lotto.util.ConstantsUtil.MESSAGE_TICKETS_PRICE_INVALID
import lotto.util.ConstantsUtil.MESSAGE_TICKETS_PRICE_NOT_INT
import lotto.util.ConstantsUtil.MESSAGE_WINNING_NUMBERS_NOT_INT
import lotto.util.ConstantsUtil.TICKET_PRICE

object ValidatorUtil {
    fun validateLottoSize(lottoSize: Int) {
        require(lottoSize == 6) {
            MESSAGE_NUMBER_SIZE_INVALID
        }
    }

    fun validateTicketsPriceNumber(ticketsPrice: String) {
        require(ticketsPrice.toIntOrNull() != null) {
            MESSAGE_TICKETS_PRICE_NOT_INT
        }
    }

    fun validateWinningNumbers(winningNumbers: List<Int?>) {
        require(winningNumbers.all { it != null }) {
            MESSAGE_WINNING_NUMBERS_NOT_INT
        }
    }

    fun validateBonusNumber(bonusNumber: String) {
        require(bonusNumber.toIntOrNull() != null) {
            MESSAGE_BONUS_NUMBERS_NOT_INT
        }
    }

    fun validateTicketsPrice(price: Int){
        require(price % TICKET_PRICE == 0) {
            MESSAGE_TICKETS_PRICE_INVALID
        }
    }

}