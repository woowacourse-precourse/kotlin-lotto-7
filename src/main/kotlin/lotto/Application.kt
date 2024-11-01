package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    readAndValidateAmount()
}

fun readAndValidateAmount() {
    while (true) {
        try {
            val amount = promptUserForAmount()
            validateAmount(amount)
            return
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun promptUserForAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val input = Console.readLine()?.trim()
    return parseAmount(input)
}

fun parseAmount(amount: String?): Int {
    if (amount.isNullOrEmpty()) {
        throw IllegalArgumentException("[ERROR] 유효한 금액을 입력해주세요.")
    }
    return amount.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 유효한 금액을 입력해주세요.")
}

fun validateAmount(amount: Int) {
    if (amount <= 0) {
        throw IllegalArgumentException("[ERROR] 유효한 금액을 입력해주세요.")
    }
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 로또 금액은 1000원 단위로 입력해야 합니다.")
    }
}
