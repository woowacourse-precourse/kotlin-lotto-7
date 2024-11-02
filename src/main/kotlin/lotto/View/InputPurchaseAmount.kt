package lotto.View

import camp.nextstep.edu.missionutils.Console

fun inputPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    return readAndValidateAmount()
}

private fun readAndValidateAmount(): Int {
    return try {
        val amount = readAmount()
        validateAmount(amount)
        amount
    } catch (e: NumberFormatException) {
        println("[ERROR] 구입금액은 숫자로 입력해야 합니다.")
        inputPurchaseAmount()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        inputPurchaseAmount()
    }
}

private fun readAmount(): Int {
    return Console.readLine().toInt()
}

private fun validateAmount(amount: Int) {
    require(amount >= 1000 && amount % 1000 == 0) {
        "[ERROR] 구입금액은 1000원 이상, 1000원 단위로 입력해야 합니다."
    }
}
