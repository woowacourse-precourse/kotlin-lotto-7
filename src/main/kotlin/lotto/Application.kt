package lotto

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println()
    val moneyForLotto = readLine().toInt()
    val countLotto = moneyForLotto / 1000

    println("${countLotto}개를 구매했습니다.")
    for (i in 0 until countLotto) {
        Lotto.randomNumber()
    }
    println("당첨 번호를 입력해 주세요.")
    val winNumber = readLine().split(",").map {it.toInt()}
    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = readLine().toInt()
    println("당첨 통계")
    println("---")

}
