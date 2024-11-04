package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.PurchaseAmount
import lotto.utils.WinningNumbers

class InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        return try {
            val amount = input.trim().toInt()
            validatePurchaseAmount(amount)
            amount
        } catch (e: Exception) {
            println("[ERROR] 구입 금액은 ${PurchaseAmount.LOTTO_PRICE.value}원 단위이며, ${PurchaseAmount.MIN_PURCHASE_AMOUNT.value}원 이상, ${PurchaseAmount.MAX_PURCHASE_AMOUNT.value}원 이하여야 합니다.")
            getPurchaseAmount()
        }
    }

    fun getWinningNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        return try {
            val numbers = input.split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
            validateWinningNumbers(numbers)
            numbers
        } catch (e: Exception) {
            println("[ERROR] 당첨 번호는 중복되지 않는 ${WinningNumbers.MIN_LOTTO_NUMBER.value}~${WinningNumbers.MAX_LOTTO_NUMBER.value} 사이의 숫자 ${WinningNumbers.WINNING_NUMBER_COUNT.value}개로 입력해야 합니다.\n숫자 외에는 구분자인 쉼표(,)만 입력할 수 있습니다.")
            getWinningNumbers()
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        println("보너스 번호를 입력해 주세요.")
        val input = Console.readLine()
        return try {
            val bonusNumber = input.trim().toInt()
            validateBonusNumber(bonusNumber, winningNumbers)
            bonusNumber
        } catch (e: Exception) {
            println("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 ${WinningNumbers.MIN_LOTTO_NUMBER.value}~${WinningNumbers.MAX_LOTTO_NUMBER.value} 사이의 숫자로 입력해야 합니다.")
            getBonusNumber(winningNumbers)
        }
    }

    fun validatePurchaseAmount(amount: Int) {
        if (amount % PurchaseAmount.LOTTO_PRICE.value != 0 ||
            amount < PurchaseAmount.MIN_PURCHASE_AMOUNT.value ||
            amount > PurchaseAmount.MAX_PURCHASE_AMOUNT.value) {
            throw IllegalArgumentException()
        }
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != WinningNumbers.WINNING_NUMBER_COUNT.value ||
            numbers.any { it !in WinningNumbers.MIN_LOTTO_NUMBER.value..WinningNumbers.MAX_LOTTO_NUMBER.value } ||
            numbers.distinct().size != numbers.size) {
                throw IllegalArgumentException()
        }
    }

    fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber !in WinningNumbers.MIN_LOTTO_NUMBER.value..WinningNumbers.MAX_LOTTO_NUMBER.value ||
            winningNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException()
        }
    }
}