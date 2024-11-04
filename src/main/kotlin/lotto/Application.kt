package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("구입 금액을 입력해 주세요.")
    val money = moneyInput()
    val repeat = money / 1000
    val lottoList: List<LottoPaper> = makeAll(repeat)
    println("당첨 번호를 입력해 주세요.")
    val numberList: List<Int> = numberInput()
    val lotto = Lotto(numberList)
    println("보너스 번호를 입력해 주세요")
    lotto.inputBonus()
    val resultList = lottoResult(lotto, lottoList)
    val earnMoney = printResult(resultList)
    println("당첨 통계")
    println("---")
    print("총 수익률은 ${String.format("%.1f", earnMoney / money.toDouble() * 100)}%입니다.")
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

fun printResult(rankList: List<Int>): Int {
    var money = 0
    for (i in 3..6) {
        println("${i}개 일치 (${LottoPrice.findPrintByKey(i)}) - ${rankList[i]}개")
        money += (LottoPrice.findPriceByKey(i)!!.times(rankList[i].toInt()))
        if (i == 5) {
            println("5개 일치,보너스 볼 일치 (${LottoPrice.findPrintByKey(i + 2)}) - ${rankList[i + 2]}개")
        }
    }
    return money
}

fun lottoResult(lotto: Lotto, lottoList: List<LottoPaper>): List<Int> {
    var resultList: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0)
    for (lottoPaper in lottoList) {
        var number = lotto.findNumbers(lottoPaper.paperNumber)
        resultList[number] += 1
        if (number == 5 && lotto.findBonus(lottoPaper.paperNumber)) {
            resultList[7] += 1
            resultList[number] -= 1
        }
    }
    return resultList
}