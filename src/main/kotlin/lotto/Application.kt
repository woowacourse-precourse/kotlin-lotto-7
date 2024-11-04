package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    // 로또 구입 금액 입력 및 검증
    val totalInvestment = inputPurchaseAmount()

    // 로또 번호 생성
    val purchasedLottos = generateLottos(totalInvestment)
    println("${purchasedLottos.size}개를 구매했습니다.")
    purchasedLottos.forEach { println(it) }

    // 당첨 번호 및 보너스 번호 입력
    val (winningNumbers, bonusNumber) = inputWinningNumbers()

    // 당첨 통계 출력
    printWinningStatistics(purchasedLottos, winningNumbers, bonusNumber, totalInvestment)
}

// 로또 구입 금액 입력 함수
private fun inputPurchaseAmount(): Int {
    var amount: Int
    while (true) {
        println("구입금액을 입력해 주세요.")
        amount = try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            println("[ERROR] 올바른 숫자를 입력해 주세요.")
            continue
        }

        try {
            Lotto.validatePurchaseAmount(amount)
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    return amount
}

// 로또 번호 생성 함수
private fun generateLottos(amount: Int): List<Lotto> {
    return List(amount / 1000) { Lotto(Lotto.generateNumbers()) }
}

// 당첨 번호 및 보너스 번호 입력 함수
private fun inputWinningNumbers(): Pair<List<Int>, Int> {
    var winningNumbers: List<Int>
    var bonusNumber: Int

    while (true) {
        try {
            println("당첨 번호를 입력해 주세요.")
            winningNumbers = Console.readLine().split(",").map { it.trim().toInt() }
            bonusNumber = readBonusNumber()
            Lotto.validateWinningNumbers(winningNumbers, bonusNumber) // 수정된 부분
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        } catch (e: NumberFormatException) {
            println("[ERROR] 올바른 숫자를 입력해 주세요.")
        }
    }
    return Pair(winningNumbers, bonusNumber)
}

// 보너스 번호 입력 함수
private fun readBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    return Console.readLine().toInt().also { number ->
        require(number in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이여야 합니다." }
    }
}

// 당첨 통계 출력 함수
private fun printWinningStatistics(purchasedLottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int, totalInvestment: Int) {
    val statistics = calculateWinningStatistics(purchasedLottos, winningNumbers, bonusNumber)
    println("당첨 통계")
    println("---")
    statistics.forEach { (key, value) ->
        println("$key - $value 개") //Unresolved reference: value개
    }

    // 수익률 계산
    val yield = calculateTotalYield(statistics, totalInvestment)
    println("총 수익률은 ${"%.1f".format(yield * 100)}%입니다.")
}

// 당첨 통계 계산 함수
private fun calculateWinningStatistics(purchasedLottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<String, Int> {
    val statistics = mutableMapOf<String, Int>()

    purchasedLottos.forEach { lotto ->
        val result = lotto.calculateWinningResults(winningNumbers, bonusNumber)
        val key = when (result.matchCount) {
            3 -> "3개 일치 (5,000원)"
            4 -> "4개 일치 (50,000원)"
            5 -> if (result.isBonusMatched) "5개 일치, 보너스 볼 일치 (30,000,000원)" else "5개 일치 (1,500,000원)"
            6 -> "6개 일치 (2,000,000,000원)"
            else -> null
        }
        key?.let { statistics[it] = (statistics[it] ?: 0) + 1 }
    }
    return statistics
}

// 수익률 계산 함수
private fun calculateTotalYield(statistics: Map<String, Int>, totalInvestment: Int): Double {
    val totalPrize = statistics.entries.sumOf { (key, count) ->
        when (key) {
            "3개 일치 (5,000원)" -> count * 5000
            "4개 일치 (50,000원)" -> count * 50000
            "5개 일치 (1,500,000원)" -> count * 1500000
            "5개 일치, 보너스 볼 일치 (30,000,000원)" -> count * 30000000
            "6개 일치 (2,000,000,000원)" -> count * 2000000000
            else -> 0
        }
    }
    return if (totalInvestment == 0) 0.0 else totalPrize.toDouble() / totalInvestment
}
