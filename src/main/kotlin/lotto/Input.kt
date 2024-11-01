package lotto

import camp.nextstep.edu.missionutils.Console

fun inputMoney() : Int {
    while (true) {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()

        try {
            return validMoney(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun validMoney(input: String) : Int  {
    val money = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.MONEY_VALID_ERROR.message)

    if (money < 1000) {
        throw IllegalArgumentException(ErrorMessage.MONEY_ERROR.message)
    }
    if (money % 1000 != 0) {
        throw IllegalArgumentException (ErrorMessage.MONEY_DIVIDE_ERROR.message)
    }

    return money
}