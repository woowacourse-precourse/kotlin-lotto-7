package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.LottoConstants

class LottoInputView {
    fun getPurchasePrice(): Int {
        val purchasePrice = Console.readLine().toInt()  // TODO: 입력 예외 처리 필요
        return purchasePrice
    }

    fun getWinningNumbers(): List<Int> {
        val winningNumbers = Console.readLine()
            .split(LottoConstants.WINNING_NUMBERS_DELIMITER)
            .map { it.toInt() }
        return winningNumbers
    }

    fun getBonusNumber(): Int {
        val trimBonusNumber = Console.readLine().trim() // TODO: 입력 예외 처리 필요
        val bonusNumber = trimBonusNumber.toInt()
        return bonusNumber
    }
}