package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Constants
import lotto.utils.ErrorConstants
import lotto.utils.InputConstants

/**
 * 뷰는 모델에만 의존해야 하고, 컨트롤러에는 의존하면 안된다.
 * 뷰 내부는 모델 코드만 있을 수 있다.
 * 뷰가 모델로부터 데이터를 받을 때는 사용자마다 다르게 보여주어야 하는데이터에 한해 받는다
 * 모델로부터 데이터를 받을 때는 컨트롤러에서 받아야한다.
 */

class InputView {

    // TODO: 예외 처리를 컨트롤러에서 하는게 나을지?
    fun getPurchaseAmount(): Int {
        while (true) {
            println(InputConstants.PURCHASE_AMOUNT_MESSAGE)
            val purchaseAmount = Console.readLine().trim().toIntOrNull()

            when {
                purchaseAmount == null -> println(ErrorConstants.NOT_NUMBER)
                purchaseAmount <= Constants.ZERO -> println(ErrorConstants.NEGATIVE_NUMBER)
                purchaseAmount % Constants.LOTTO_PRICE != Constants.ZERO -> println(ErrorConstants.NOT_DIVIDED)
                purchaseAmount > Constants.LIMIT_OF_PURCHASE -> println(ErrorConstants.LIMIT_OF_PURCHASE)
                else -> return purchaseAmount
            }
        }
    }

    fun getWinningNumbers(): List<Int> {
        println(InputConstants.WINNING_NUMBERS_MESSAGE)
        val winningNumbers = Console.readLine()
        return winningNumbers.split(",").map { it.toIntOrNull()!! } ?: throw IllegalArgumentException ("")

    }

    fun getBonusNumber(): String {
        println(InputConstants.BONUS_NUMBER_MESSAGE)
        return Console.readLine()
    }
}