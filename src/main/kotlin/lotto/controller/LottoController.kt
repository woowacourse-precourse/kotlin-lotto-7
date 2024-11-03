package lotto.controller

import camp.nextstep.edu.missionutils.Console

class LottoController {
    val purchaseAmount = getPurchaseAmount()
}

fun getPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val input = Console.readLine()
    return try {
        val amount = input.toInt()
        validatePurchaseAmount(amount)
        amount
    } catch (e: Exception) {
        println("[ERROR] 구입 금액은 1,000원 단위의 숫자로 입력해야 합니다.")
        getPurchaseAmount()
    }
}

fun validatePurchaseAmount(amount: Int) {
    if (amount % 1000 != 0 || amount < 1000 || amount > 1_000_000) {
        throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 1,000,000원 이하이어야 합니다.")
    }
}