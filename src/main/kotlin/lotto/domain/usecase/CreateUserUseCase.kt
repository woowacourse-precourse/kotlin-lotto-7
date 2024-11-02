package lotto.domain.usecase

import lotto.domain.entity.User
import lotto.domain.validator.PurchasePriceValidator

class CreateUserUseCase(
    private val purchasePriceValidator: PurchasePriceValidator = PurchasePriceValidator()
) {
    fun execute(priceInput: () -> String): User {
        while (true) {
            try {
                val input = priceInput()
                val lottoCost = purchasePriceValidator.parseNumberInput(input)
                purchasePriceValidator.validateMoney(lottoCost)
                return User(lottoCost)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}