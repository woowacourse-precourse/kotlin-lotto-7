package lotto.util
import lotto.util.ConstantsUtil.MESSAGE_NUMBER_SIZE_ERROR
object ValidatorUtil {
    fun validateLottoSize(lottoSize: Int) {
        require(lottoSize == 6) {
            MESSAGE_NUMBER_SIZE_ERROR
        }
    }

    fun validateTicketsPrice(ticketsPrice: String) {
        require(ticketsPrice.toIntOrNull() != null) {
            MESSAGE_TICKETS_PRICE_NOT_INT
        }
    }

    fun validateWinningNumbers(winningNumbers: List<Int?>) {
        require(winningNumbers.all { it != null }) {
            MESSAGE_WINNING_NUMBERS_NOT_INT
        }
    }
}