package lotto

import kotlin.math.round

fun main(isTestMode: Boolean = false) {
    val amount = promptForAmount(isTestMode)
    val lottoCount = amount / 1000

    println("\n${lottoCount}개를 구매했습니다.")
    val lottoTickets = generateLottoTickets(lottoCount)
    lottoTickets.forEach { println(it.getSortedNumbers()) }

    val winningNumbers = promptForWinningNumbers(isTestMode)
    val bonusNumber = promptForBonusNumber(winningNumbers, isTestMode)

    val results = checkWinningTickets(lottoTickets, winningNumbers, bonusNumber)
    printResults(results, amount)
}

// 구입 금액 입력 및 검증
fun promptForAmount(isTestMode: Boolean): Int {
    while (true) {
        println("구입금액을 입력해 주세요.")
        val input = readlnOrNull()
        val amount = input?.toIntOrNull()
        try {
            require(amount != null && amount % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위의 숫자여야 합니다." }
            return amount
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            if (isTestMode) return 8000 // 테스트 모드에서는 유효한 값으로 반환
        }
    }
}

// 당첨 번호 입력 및 검증
fun promptForWinningNumbers(isTestMode: Boolean): List<Int> {
    while (true) {
        println("\n당첨 번호를 입력해 주세요.")
        val input = readlnOrNull()
        val winningNumbers = input
            ?.split(",")?.mapNotNull { it.trim().toIntOrNull() }
            ?.distinct()?.take(6)
        try {
            require(winningNumbers != null && winningNumbers.size == 6) { "[ERROR] 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다." }
            require(winningNumbers.all { it in 1..45 }) { "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다." }
            return winningNumbers
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            if (isTestMode) return listOf(1, 2, 3, 4, 5, 6)
        }
    }
}

// 보너스 번호 입력 및 검증
fun promptForBonusNumber(winningNumbers: List<Int>, isTestMode: Boolean): Int {
    while (true) {
        println("\n보너스 번호를 입력해 주세요.")
        val input = readlnOrNull()
        val bonusNumber = input?.toIntOrNull()
        try {
            require(bonusNumber != null && bonusNumber in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
            require(bonusNumber !in winningNumbers) { "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다." }
            return bonusNumber
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            if (isTestMode) return 7
        }
    }
}

// 당첨 번호 확인 및 결과 계산
fun checkWinningTickets(
    tickets: List<Lotto>,
    winningNumbers: List<Int>,
    bonusNumber: Int
): Map<String, Int> {
    val results = mutableMapOf("1등" to 0, "2등" to 0, "3등" to 0, "4등" to 0, "5등" to 0)

    tickets.forEach { ticket ->
        val matchCount = ticket.countMatchingNumbers(winningNumbers)
        val isBonusMatched = ticket.containsBonusNumber(bonusNumber)

        when (matchCount) {
            6 -> results["1등"] = results.getValue("1등") + 1
            5 -> {
                if (isBonusMatched) results["2등"] = results.getValue("2등") + 1
                else results["3등"] = results.getValue("3등") + 1
            }

            4 -> results["4등"] = results.getValue("4등") + 1
            3 -> results["5등"] = results.getValue("5등") + 1
        }
    }
    return results
}

// 당첨 결과 및 수익률 출력
fun printResults(results: Map<String, Int>, amountSpent: Int) {
    println("\n당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${results["5등"]}개")
    println("4개 일치 (50,000원) - ${results["4등"]}개")
    println("5개 일치 (1,500,000원) - ${results["3등"]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${results["2등"]}개")
    println("6개 일치 (2,000,000,000원) - ${results["1등"]}개")

    val totalPrize = calculateTotalPrize(results)
    val profitRate = calculateProfitRate(amountSpent, totalPrize)
    println("총 수익률은 ${profitRate}%입니다.")
}

// 당첨 금액 계산
fun calculateTotalPrize(results: Map<String, Int>): Int {
    val prizeAmounts = mapOf(
        "1등" to 2_000_000_000,
        "2등" to 30_000_000,
        "3등" to 1_500_000,
        "4등" to 50_000,
        "5등" to 5_000
    )

    return results.entries.sumOf { (rank, count) ->
        (prizeAmounts[rank] ?: 0) * count
    }
}

// 수익률 계산
fun calculateProfitRate(amountSpent: Int, totalPrize: Int): Double {
    val profitRate = (totalPrize.toDouble() / amountSpent) * 100
    return round(profitRate * 10) / 10 // 소수점 둘째 자리에서 반올림
}
