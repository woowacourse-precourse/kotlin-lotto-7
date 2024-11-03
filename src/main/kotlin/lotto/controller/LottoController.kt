package lotto.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto

class LottoController {
    fun run() {
        val purchaseAmount = getPurchaseAmount()
        val lottos = purchaseLottos(purchaseAmount)
        printLottos(lottos)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        val statistics = calculateStatistics(lottos, winningNumbers, bonusNumber)
        printStatistics(statistics, purchaseAmount)
    }
}

fun getPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val input = Console.readLine()
    return try {
        val amount = input.trim().toInt()
        validatePurchaseAmount(amount)
        amount
    } catch (e: Exception) {
        println("[ERROR] 구입 금액은 1,000원 단위의 숫자로 입력해야 합니다.")
        getPurchaseAmount()
    }
}

fun validatePurchaseAmount(amount: Int) {
    if (amount % 1000 != 0 || amount < 1000 || amount > 1_000_000) {
        throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 1,000,000원 이하이어야 합니다.")
    }
}

fun purchaseLottos(amount: Int): List<Lotto> {
    val numberOfLottos = amount / 1000
    return List(numberOfLottos) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
}

fun printLottos(lottos: List<Lotto>) {
    println("${lottos.size}개를 구매했습니다.")
    lottos.forEach { println(it.getNumbers().sorted()) }
}

fun getWinningNumbers(): Set<Int> {
    println("당첨 번호를 입력해 주세요.")
    val input = Console.readLine()
    return try {
        val numbers = input.split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
            .toSet()
        validateWinningNumbers(numbers)
        numbers
    } catch (e: Exception) {
        println("[ERROR] 당첨 번호는 1~45 사이의 숫자 6개를 중복 없이 입력해야 합니다.")
        getWinningNumbers()
    }
}

fun validateWinningNumbers(numbers: Set<Int>) {
    if (numbers.size != 6 || numbers.any { it !in 1..45 }) {
        throw IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자 6개여야 합니다.")
    }
}

fun getBonusNumber(winningNumbers: Set<Int>): Int {
    println("보너스 번호를 입력해 주세요.")
    val input = Console.readLine()
    return try {
        val bonusNumber = input.trim().toInt()
        validateBonusNumber(bonusNumber, winningNumbers)
        bonusNumber
    } catch (e: Exception) {
        println("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 숫자여야 합니다.")
        getBonusNumber(winningNumbers)
    }
}

fun validateBonusNumber(bonusNumber: Int, winningNumbers: Set<Int>) {
    if (bonusNumber !in 1..45 || winningNumbers.contains(bonusNumber)) {
        throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 숫자여야 합니다.")
    }
}

fun calculateStatistics(lottos: List<Lotto>, winningNumbers: Set<Int>, bonusNumber: Int): Map<String, Int> {
    val statistics = mutableMapOf(
        "3개 일치 (5,000원)" to 0,
        "4개 일치 (50,000원)" to 0,
        "5개 일치 (1,500,000원)" to 0,
        "5개 일치, 보너스 볼 일치 (30,000,000원)" to 0,
        "6개 일치 (2,000,000,000원)" to 0
    )

    lottos.forEach { lotto ->
        val matchCount = lotto.getNumbers().count { winningNumbers.contains(it) }
        when (matchCount) {
            6 -> statistics["6개 일치 (2,000,000,000원)"] = statistics.getValue("6개 일치 (2,000,000,000원)") + 1
            5 -> if (lotto.getNumbers().contains(bonusNumber)) {
                statistics["5개 일치, 보너스 볼 일치 (30,000,000원)"] = statistics.getValue("5개 일치, 보너스 볼 일치 (30,000,000원)") + 1
            } else {
                statistics["5개 일치 (1,500,000원)"] = statistics.getValue("5개 일치 (1,500,000원)") + 1
            }
            4 -> statistics["4개 일치 (50,000원)"] = statistics.getValue("4개 일치 (50,000원)") + 1
            3 -> statistics["3개 일치 (5,000원)"] = statistics.getValue("3개 일치 (5,000원)") + 1
        }
    }
    return statistics
}

fun printStatistics(statistics: Map<String, Int>, purchaseAmount: Int) {
    println("당첨 통계\n---")
    statistics.forEach { (key, value) -> println("$key - ${value}개") }
    val totalPrize = calculateRateOfReturn(statistics)
    val profitRate = (totalPrize / purchaseAmount.toDouble()) * 100
    println("총 수익률은 ${"%.1f".format(profitRate)}%입니다.")
}

fun calculateRateOfReturn(statistics: Map<String, Int>): Int {
    return statistics.entries.sumOf { (key, count) ->
        val prize = when (key) {
            "3개 일치 (5,000원)" -> 5000
            "4개 일치 (50,000원)" -> 50000
            "5개 일치 (1,500,000원)" -> 1_500_000
            "5개 일치, 보너스 볼 일치 (30,000,000원)" -> 30_000_000
            "6개 일치 (2,000,000,000원)" -> 2_000_000_000
            else -> 0
        }
        prize * count
    }
}
