package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    val money = moneyInput()
    val repeat = money / 1000
    val lottoList: List<LottoPaper> = makeAll(repeat)
    val numberList: List<Int> = numberInput()
    val lotto = Lotto(numberList)
    lotto.inputBonus()
    //result(lotto,lottoList)

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

fun makeAll(repeat: Int): List<LottoPaper> {
    val lottoList: MutableList<LottoPaper> = mutableListOf()
    println("${repeat}개를 구매했습니다")
    for (i in 1..repeat) {
        val paper = LottoPaper()
        paper.printNumber()
        lottoList.add(paper)
    }
    return lottoList
}
