package lotto.view

import camp.nextstep.edu.missionutils.Console

/**
 * 뷰는 모델에만 의존해야 하고, 컨트롤러에는 의존하면 안된다.
 * 뷰 내부는 모델 코드만 있을 수 있다.
 * 뷰가 모델로부터 데이터를 받을 때는 사용자마다 다르게 보여주어야 하는데이터에 한해 받는다
 * 모델로부터 데이터를 받을 때는 컨트롤러에서 받아야한다.
 */

class InputView {

    fun getPurchaseAmount(): Int {
        while (true) {
            println(PURCHASE_AMOUNT_INPUT_MESSAGE)
            val purchaseAmount = Console.readLine().toIntOrNull()

            when {
                purchaseAmount == null -> println(ERROR_NOT_NUMBER)
                purchaseAmount <= ZERO -> println(ERROR_NEGATIVE_NUMBER)
                purchaseAmount % LOTTO_PRICE != ZERO -> println(ERROR_NOT_DIVIDED)
                purchaseAmount > LIMIT_OF_PURCHASE -> println(ERROR_LIMIT_OF_PURCHASE)
                else -> return purchaseAmount
            }
        }
    }

    fun getWinningNumbers(): String {
        println(WINNING_NUMBERS_INPUT_MESSAGE)
        return Console.readLine()
    }

    fun getBonusNumber(): String {
        println(BONUS_NUMBER_INPUT_MESSAGE)
        return Console.readLine()
    }

    companion object {
        const val PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요."
        const val WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요."
        const val BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요."

        const val ERROR_NOT_NUMBER = "[ERROR] 정수형 숫자만 입력 가능합니다. 원화 단위로 입력해주세요."
        const val ERROR_NEGATIVE_NUMBER = "[ERROR] 저희 가게는 외상을 받지 않습니다."
        const val ERROR_NOT_DIVIDED = "[ERROR] 로또 1장당 1000원입니다. 잔돈은 필요 없어요!"
        const val ERROR_LIMIT_OF_PURCHASE = "[ERROR] 1인당 최대 구매 가능 금액은 10만원입니다."

        const val ZERO = 0
        const val LOTTO_PRICE = 1000
        const val LIMIT_OF_PURCHASE = 100000
    }
}