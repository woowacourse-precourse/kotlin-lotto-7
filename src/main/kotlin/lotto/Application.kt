package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")
    val inputPrice = getUserInput()
    val numberOfLotto = purchasedLotto(inputPrice)
    println("${numberOfLotto}개를 구매했습니다.")


}

private fun getUserInput(): String = Console.readLine()

private fun purchasedLotto(inputPrice: String): Int = inputPrice.toInt() / 1000