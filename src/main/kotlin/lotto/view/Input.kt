package lotto.view

import lotto.constants.InputConstants.BONUS_NUMBER_MSG
import lotto.constants.InputConstants.PURCHASED_QUANTITY_MSG
import lotto.constants.InputConstants.PURCHASE_PRICE_MSG
import lotto.constants.InputConstants.WINNING_NUMBERS_MSG
import lotto.domain.Lotto

class Input {
    fun purchasePriceMsg() {
        println(PURCHASE_PRICE_MSG)
    }

    fun winningNumbersMsg() {
        println(WINNING_NUMBERS_MSG)
    }

    fun bonusNumberMsg() {
        println(BONUS_NUMBER_MSG)
    }

    fun purchasedQuantityMsg(count: Int, lottos: List<Lotto>) {
        println("$count$PURCHASED_QUANTITY_MSG")
        for (i in lottos.indices) {
            println(lottos[i])
        }
    }
}
