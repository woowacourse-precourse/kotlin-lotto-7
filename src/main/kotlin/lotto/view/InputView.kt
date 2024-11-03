package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.INPUT_LOTTO_PURCHASE_MESSAGE

class InputView {
    fun purchaseLottoMessage(): String {
        print(INPUT_LOTTO_PURCHASE_MESSAGE)
        return Console.readLine()
    }
}