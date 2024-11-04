package lotto.view

import camp.nextstep.edu.missionutils.Console

fun purchaseAmountView(): String {
    println("구입 금액을 입력하세요.")

    return Console.readLine()
}