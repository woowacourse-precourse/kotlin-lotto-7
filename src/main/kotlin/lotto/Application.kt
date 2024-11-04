package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val amount = readAndValidateAmount()
    val numberOfLottos = calculateNumberOfLottos(amount)
    println("${numberOfLottos}개를 구매했습니다.")

    val userLottos = generateLottos(numberOfLottos)
    userLottos.forEach { println(it) }

    val winningNumbers = readLottoNumber()
    val bonusNumber = readBonusNumber(winningNumbers)

    val results = calculateResults(userLottos, winningNumbers, bonusNumber)
    printResults(results, amount)
}

fun readAndValidateAmount(): Int {
    while (true) {
        try {
            val amount = promptUserForAmount()
            Validation.validateAmount(amount)
            return amount
        } catch (e: IllegalArgumentException) {
            println(e.message) // 예외 메시지를 출력하고 입력을 다시 받는다.
        }
    }
}

fun promptUserForAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val input = Console.readLine()?.trim()
    return Validation.parseAmount(input)
}

fun calculateNumberOfLottos(amount: Int): Int = amount / 1000

fun generateLottos(count: Int): List<Lotto> = List(count) { Lotto(generateRandomLottoNumbers()) }

fun generateRandomLottoNumbers(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()

fun readLottoNumber(): List<Int> {
    while (true) {
        try {
            val input = promptUserForLotto()
            val numbers = Validation.parseLottoNumbers(input)
            Validation.validateLottoNumbers(numbers)
            return numbers
        } catch (e: IllegalArgumentException) {
            println(e.message) // 예외 메시지가 "[ERROR]"로 시작하는지 확인
        }
    }
}

fun promptUserForLotto(): String {
    println("\n당첨 번호를 입력해 주세요.")
    return Console.readLine()?.trim().orEmpty()
}

fun readBonusNumber(winningNumbers: List<Int>): Int {
    while (true) {
        try {
            println("\n보너스 번호를 입력해 주세요.")
            val input = Console.readLine()?.trim()
            return Validation.validateBonusNumber(input, winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun calculateResults(userLottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<LottoResult, Int> {
    return userLottos.groupingBy {
        val matchCount = it.getMatchCount(winningNumbers)
        val matchBonus = matchCount == 5 && it.containsNumber(bonusNumber)
        LottoResult.getResult(matchCount, matchBonus)
    }.eachCount()
}

fun printResults(results: Map<LottoResult, Int>, amountSpent: Int) {
    println("\n당첨 통계")
    println("---")

    val totalEarnings = results.entries.sumOf { (result, count) -> result.prize * count }

    LottoResult.values()
        .reversed() // 순서를 뒤집어서 출력
        .filter { it != LottoResult.NONE }
        .forEach { result ->
            val count = results.getOrDefault(result, 0)
            val formattedPrize = "%,d".format(result.prize) // 숫자에 쉼표 추가
            val resultLine = if (result == LottoResult.SECOND) {
                "5개 일치, 보너스 볼 일치 (${formattedPrize}원) - ${count}개"
            } else {
                "${result.matchCount}개 일치 (${formattedPrize}원) - ${count}개"
            }
            println(resultLine)
        }

    val returnRate = (totalEarnings.toDouble() / amountSpent) * 100
    println("총 수익률은 ${"%.1f".format(returnRate)}%입니다.")
}

