package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    val money = moneyInput()
    //val numberList:List<Int>
}

fun moneyInput(): Int? {
    val moneyInput = Console.readLine().toIntOrNull() ?: throw (IllegalArgumentException("[ERROR]숫자가 아닙니다."))
    if (moneyInput % 1000 != 0) {
        throw (IllegalStateException("[ERROR]천원 단위의 금액이 아닙니다."))
    }
    return moneyInput
}