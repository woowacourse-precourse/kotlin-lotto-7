package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Constants

class InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        return try {
            val amount = input.trim().toInt()
            validatePurchaseAmount(amount)
            amount
        } catch (e: Exception) {
            println("[ERROR] 구입 금액은 ${Constants.LOTTO_PRICE}원 단위이며, ${Constants.MIN_PURCHASE_AMOUNT}원 이상, ${Constants.MAX_PURCHASE_AMOUNT}원 이하여야 합니다.")
            getPurchaseAmount()
        }
    }

    fun getWinningNumbers(): Set<Int> {
        println("당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        return try {
            val numbers = input.split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
                .toSet()
            validateWinningNumbers(numbers)
            numbers
        } catch (e: Exception) {
            println("[ERROR] 당첨 번호는 중복되지 않는 ${Constants.MIN_LOTTO_NUMBER}~${Constants.MAX_LOTTO_NUMBER} 사이의 숫자 ${Constants.WINNING_NUMBER_COUNT}개로 입력해야 합니다.\n숫자 외에는 구분자인 쉼표(,)만 입력할 수 있습니다.")
            getWinningNumbers()
        }
    }

    fun getBonusNumber(winningNumbers: Set<Int>): Int {
        println("보너스 번호를 입력해 주세요.")
        val input = Console.readLine()
        return try {
            val bonusNumber = input.trim().toInt()
            validateBonusNumber(bonusNumber, winningNumbers)
            bonusNumber
        } catch (e: Exception) {
            println("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 ${Constants.MIN_LOTTO_NUMBER}~${Constants.MAX_LOTTO_NUMBER} 사이의 숫자로 입력해야 합니다.")
            getBonusNumber(winningNumbers)
        }
    }

    private fun validatePurchaseAmount(amount: Int) {
        if (amount % Constants.LOTTO_PRICE != 0 || amount < Constants.MIN_PURCHASE_AMOUNT || amount > Constants.MAX_PURCHASE_AMOUNT) {
            throw IllegalArgumentException()
        }
    }

    private fun validateWinningNumbers(numbers: Set<Int>) {
        if (numbers.size != Constants.WINNING_NUMBER_COUNT || numbers.any { it !in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER }) {
            throw IllegalArgumentException()
        }
    }

    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: Set<Int>) {
        if (bonusNumber !in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER || winningNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException()
        }
    }
}