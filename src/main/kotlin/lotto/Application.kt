package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해 주세요.")
    val inputPrice = getUserInput()
    val numberOfLotto = purchasedLotto(inputPrice)
    println("${numberOfLotto}개를 구매했습니다.")
    // 로또 번호 출력하기
    lottoNumbersResult(numberOfLotto)
}

private fun getUserInput(): String = Console.readLine()

private fun purchasedLotto(inputPrice: String): Int = inputPrice.toInt() / 1000

private fun lottoNumbers(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)

private fun lottoNumbersResult(numberOfLotto: Int) {
    for (i in 1..numberOfLotto) {
        val lottoNumber = lottoNumbers()
        println(lottoNumber)
    }
}