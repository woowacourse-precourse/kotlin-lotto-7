// Main.kt 파일 수정
package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해 주세요.")
    val inputPrice = getUserInput()
    val lottoCount = purchasedLotto(inputPrice)
    println()
    println("${lottoCount}개를 구매했습니다.")

    val randomNumbers = randomNumberResult(lottoCount)

    println()
    println("당첨 번호를 입력해 주세요.")
    val winningNumber = getWinningNumbers()
    println()
    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = getBonusNumber()

    val matchNumbers = checkWinningNumber(randomNumbers, winningNumber)


}

private fun getUserInput(): String = Console.readLine()

private fun purchasedLotto(inputPrice: String): Int = inputPrice.toInt() / 1000

private fun randomNumberResult(lottoCount: Int): List<List<Int>> {
    val lottoNumbers = mutableListOf<List<Int>>()
    repeat(lottoCount) {
        val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        println(lottoNumber)
        lottoNumbers.add(lottoNumber)
    }
    return lottoNumbers
}

private fun getWinningNumbers(): List<Int> {
    val winningNumber = getUserInput()
    return winningNumber.split(",").map { it.trim().toInt() }
}

private fun checkWinningNumber(randomNumbers: List<List<Int>>, winningNumbers: List<Int>): List<Int>{
    val resultNumber = mutableListOf<Int>()
    randomNumbers.forEach{ randomNumber ->
        val matchCount = Lotto(randomNumber).matchCount(winningNumbers)
        if(matchCount >= 5){

        }
    }
    println(resultNumber)
    return resultNumber
}

private fun getBonusNumber(): Int = getUserInput().toInt()
