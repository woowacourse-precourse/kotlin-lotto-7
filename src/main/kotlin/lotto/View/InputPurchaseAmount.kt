package lotto.View

import camp.nextstep.edu.missionutils.Console

fun inputPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    return try {
        val amount = Console.readLine().toInt()
        if (amount < 1000 || amount % 1000 != 0) {
            println("[ERROR] 구입금액은 1000원 이상, 1000원 단위로 입력해야 합니다.")
            inputPurchaseAmount()
        }
        amount
    } catch (e: NumberFormatException) {
        println("[ERROR] 구입금액은 숫자로 입력해야 합니다.")
        inputPurchaseAmount()
    } catch (e: IllegalArgumentException) {
        println(e.message) // 오류 메시지 출력
        inputPurchaseAmount() // 다시 입력받기
    }
}
