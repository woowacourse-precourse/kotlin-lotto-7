package lotto.domain.usecase

import lotto.domain.entity.User
import lotto.extention.parseToIntOrThrow

class CreateUserUseCase {
    fun execute(priceInput: () -> String): User {
        while (true) {
            try {
                val lottoCost = priceInput().parseToIntOrThrow()
                return User(lottoCost)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}