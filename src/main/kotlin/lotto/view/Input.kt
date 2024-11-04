package lotto.view

import lotto.constants.InputConstants.BONUS_NUMBER_MESSAGE
import lotto.constants.InputConstants.PURCHASED_QUANTITY_MESSAGE
import lotto.constants.InputConstants.PURCHASE_PRICE_MESSAGE
import lotto.constants.InputConstants.WINNING_NUMBERS_MESSAGE
import lotto.domain.Lotto

class Input {
    fun purchasePriceMessage() {
        println(PURCHASE_PRICE_MESSAGE)
    }

    fun winningNumbersMessage() {
        println(WINNING_NUMBERS_MESSAGE)
    }

    fun bonusNumberMessage() {
        println(BONUS_NUMBER_MESSAGE)
    }

    fun purchasedQuantityMessage(count: Int, lottos: List<Lotto>) {
        println("$count$PURCHASED_QUANTITY_MESSAGE")
        for (i in lottos.indices) {
            println(lottos[i])
        }
    }
}
