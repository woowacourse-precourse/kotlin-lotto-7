package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    val money = moneyInput()
    val numberList: List<Int> = numberInput()

    val lotto = Lotto(numberList)
    lotto.inputBonus()

}

fun moneyInput(): Int {
    val moneyInput = Console.readLine().toIntOrNull() ?: throw (IllegalArgumentException("[ERROR]숫자가 아닙니다."))
    if (moneyInput % 1000 != 0) {
        throw (IllegalStateException("[ERROR]천원 단위의 금액이 아닙니다."))
    }
    return moneyInput
}

fun numberInput(): List<Int> {
    val numberList: MutableList<Int> = mutableListOf()
    val tmpList: List<String> = Console.readLine().split(",")
    for (tmp in tmpList) {
        val number = tmp.toIntOrNull() ?: throw (IllegalArgumentException("[ERROR]숫자가 아닙니다."))
        numberList.add(number)
    }
    return numberList
}