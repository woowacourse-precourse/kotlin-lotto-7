package lotto.view

import camp.nextstep.edu.missionutils.Console


fun purchaseAmountView(): String {
    println("구입금액을 입력해 주세요.")
    return Console.readLine()
}