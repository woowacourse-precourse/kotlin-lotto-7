package lotto

class CreateUserUseCase {
    fun execute(input: () -> String): User {
        while (true) {
            try {
                val lottoCost = input().toIntOrNull()
                requireNotNull(lottoCost) { "[ERROR] 숫자만 입력해주세요." }
                return User(lottoCost)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}