package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")
    val price = Console.readLine()
    val count = price.toInt() / 1000
    println("\n${count}개를 구매했습니다.")
}
