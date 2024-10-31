package lotto.view

import camp.nextstep.edu.missionutils.Console

/**
 * 뷰는 모델에만 의존해야 하고, 컨트롤러에는 의존하면 안된다.
 * 뷰 내부는 모델 코드만 있을 수 있다.
 * 뷰가 모델로부터 데이터를 받을 때는 사용자마다 다르게 보여주어야 하는데이터에 한해 받는다
 * 모델로부터 데이터를 받을 때는 컨트롤러에서 받아야한다.
 */

class InputView {

    fun getPurchaseAmount(): String {
        println(PURCHASE_AMOUNT_INPUT_MESSAGE)
        return Console.readLine()
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
    }
}