package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Constants.DELIMETER
import lotto.utils.ErrorConstants
import lotto.utils.InputConstants

class InputView {

    fun getPurchaseAmount(): Int? {
        println(InputConstants.PURCHASE_AMOUNT_MESSAGE)
        return Console.readLine().trim().toIntOrNull()
    }

    fun getWinningNumbers(): List<Int> {
        println(InputConstants.WINNING_NUMBERS_MESSAGE)
        return Console.readLine().split(DELIMETER).sorted()
            .map { it.toIntOrNull() ?: throw IllegalArgumentException(ErrorConstants.LOTTO_INPUT_FORMAT) }
    }

    fun getBonusNumber(): Int? {
        println(InputConstants.BONUS_NUMBER_MESSAGE)
        return Console.readLine().toIntOrNull()
    }
}