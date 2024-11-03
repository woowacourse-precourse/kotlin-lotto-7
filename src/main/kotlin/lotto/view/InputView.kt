package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.INPUT_BONUS_NUMBER_MESSAGE
import lotto.Constants.INPUT_LOTTO_PURCHASE_MESSAGE
import lotto.Constants.INPUT_WIN_LOTTO_NUMBERS_MESSAGE

class InputView {
    fun purchaseLottoMessage(): String {
        print(INPUT_LOTTO_PURCHASE_MESSAGE)
        return Console.readLine()
    }

    fun getWinLottoNumbers(): List<Int> {
        print("\n" + INPUT_WIN_LOTTO_NUMBERS_MESSAGE)
        val input = Console.readLine()

        return input.split(",")
            .map { it.trim().toInt() }
            .toList()
    }

    fun getBonusNumber(): String {
        print("\n" + INPUT_BONUS_NUMBER_MESSAGE)
        return Console.readLine()
    }
}