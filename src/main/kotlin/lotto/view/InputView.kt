package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto
import lotto.domain.PurchaseAmount

object InputView {
    fun inputPurchaseMoney(): PurchaseAmount {
        println(INPUT_PURCHASE_MONEY_MESSAGE)
        val money = Console.readLine().toInt()
        return PurchaseAmount(money)
    }

    fun inputWinningNumber(): Lotto {
        println(INPUT_WINNING_NUMBER_MESSAGE)
        val winningNumbers = Console.readLine().split(NUMBER_DELIMITER).map { it.toInt() }
        return Lotto(winningNumbers)
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        val bonusNumber = Console.readLine().toInt()
        return bonusNumber
    }

    private const val INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."

    private const val NUMBER_DELIMITER = ','
}