package lotto

import camp.nextstep.edu.missionutils.Console

enum class LottoError(val message: String) {
    INVALID_AMOUNT("[ERROR] 유효한 금액을 입력해주세요."),
    INVALID_UNIT("[ERROR] 로또 금액은 1000원 단위로 입력해야 합니다.");

    fun throwException(): IllegalArgumentException {
        return IllegalArgumentException(this.message)
    }
}

fun main() {
    readAndValidateAmount()
}

fun readAndValidateAmount() {
    while (true) {
        val amount = try {
            promptUserForAmount()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            continue
        }
        Validation.validateAmount(amount)
        return
    }
}

fun promptUserForAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val input = Console.readLine()?.trim()
    return Validation.parseAmount(input)
}
