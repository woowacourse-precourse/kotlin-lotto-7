package lotto

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    fun readLottoAmount(): Int {
        print("구입금액을 입력해 주세요.\n")
        val input = Console.readLine()

        require(input.isNotEmpty()) { "[ERROR] 구입 금액을 입력해야 합니다." }

        return try {
            val amount = input.toInt()

            require(amount > 0) { "[ERROR] 구입 금액은 0보다 커야 합니다." }
            amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.")
        }
    }
}