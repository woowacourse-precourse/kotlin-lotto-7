package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto
import org.assertj.core.internal.ErrorMessages

class InputView {
    fun readPurchaseAmount(): Int {
        while (true) {
            println("구입금액을 입력해 주세요.")
            val input = Console.readLine()
            try {
                return validatePurchaseAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWinningNumbers(): List<Int?> {
        while (true) {
            println("\n당첨 번호를 입력해주세요.")
            val input = Console.readLine()
            val numbers = input.split(",")
                .map { it.trim().toIntOrNull() }
            try {
                return validateWinningNumbers(numbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumber(winningNumbers: List<Int?>): Int {
        while (true) {
            println("\n보너스 번호를 입력해주세요.")
            val bonusNumber = Console.readLine()
            try {
                // 보너스 중복 확인
                return validateBonusNumber(bonusNumber, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validatePurchaseAmount(input: String): Int {
        val amount =
            input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.errorMessage)
        require(input.toInt() > 0) { ErrorMessage.PURCHASE_AMOUNT_ZERO.errorMessage }
        require(input.toInt() % Lotto.PRICE == 0) { ErrorMessage.INVALID_PURCHASE_MONEY.errorMessage }

        return input.toInt()
    }

    fun validateWinningNumbers(numbers: List<Int?>): List<Int?> {
        require(numbers.size == Lotto.LOTTO_NUMBER_SIZE) { ErrorMessage.INVALID_NUMBERS_COUNT.errorMessage }
        require(numbers.all { it != null && it in Lotto.MINIMUM_NUMBER..Lotto.MAXIMUM_NUMBER }) { ErrorMessage.INVALID_NUMBER_RANGE.errorMessage }
        require(numbers.size == numbers.toSet().size) { ErrorMessage.DUPLICATE_NUMBERS.errorMessage }

        return numbers
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int?>): Int {
        val bonusNumber =
            input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.errorMessage)

        require(bonusNumber in Lotto.MINIMUM_NUMBER..Lotto.MAXIMUM_NUMBER) { ErrorMessage.INVALID_BONUS_NUMBER_RANGE.errorMessage }
        require(bonusNumber !in winningNumbers) { ErrorMessage.DUPLICATE_BONUS_NUMBER.errorMessage }

        return bonusNumber
    }
}