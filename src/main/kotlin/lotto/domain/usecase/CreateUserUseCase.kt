package lotto.domain.usecase

import lotto.domain.entity.User
import lotto.extention.parseToIntOrThrow

class CreateUserUseCase {
    fun execute(purchaseAmountInput: () -> String): User {
        while (true) {
            try {
                val lottoCost = purchaseAmountInput().parseToIntOrThrow()
                return User(lottoCost)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}