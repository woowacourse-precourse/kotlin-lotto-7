package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.NumberFormatException

fun main() {
    val purchaseAmount = readAndValidatePurchaseAmount() ?: return

    val numberOfLottos = purchaseAmount / 1000
    val lottos = List(numberOfLottos) {
        Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
    }
    println("${numberOfLottos}개를 구매했습니다.")
    lottos.forEach { println(it) }

    val winningNumbers = readAndValidateWinningNumbers() ?: return
    val bonusNumber = readAndValidateBonusNumber(winningNumbers) ?: return

    val results = lottos.map { lotto ->
        val matchCount = lotto.countMatchingNumbers(winningNumbers)
        val bonusMatch = lotto.containsBonusNumber(bonusNumber)
        when (matchCount) {
            6 -> "1등"
            5 -> if (bonusMatch) "2등" else "3등"
            4 -> "4등"
            3 -> "5등"
            else -> "꽝"
        }
    }
    val prizeStatistic = getPrizeStatistic(lottos, winningNumbers, bonusNumber)

    println("당첨 통계\n---")
    println("3개 일치 (5,000원) - ${prizeStatistic.getOrDefault("5등", 0)}개")
    println("4개 일치 (50,000원) - ${prizeStatistic.getOrDefault("4등", 0)}개")
    println("5개 일치 (1,500,000원) - ${prizeStatistic.getOrDefault("3등", 0)}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${prizeStatistic.getOrDefault("2등", 0)}개")
    println("6개 일치 (2,000,000,000원) - ${prizeStatistic.getOrDefault("1등", 0)}개")


    val profitRate = calculateProfitRate(prizeStatistic, purchaseAmount)
    println("총 수익률은 ${"%.1f".format(profitRate)}%입니다.")
}

fun getPrizeStatistic(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<String, Int> {
    val results = lottos.map { lotto ->
        val matchCount = lotto.countMatchingNumbers(winningNumbers)
        val bonusMatch = lotto.containsBonusNumber(bonusNumber)
        when (matchCount) {
            6 -> "1등"
            5 -> if (bonusMatch) "2등" else "3등"
            4 -> "4등"
            3 -> "5등"
            else -> "꽝"
        }
    }
    return results.groupingBy { it }.eachCount()
}

fun calculateProfitRate(prizeStatistic: Map<String, Int>, purchaseAmount: Int): Double {
    val totalPrize = prizeStatistic.getOrDefault("1등", 0) * 2_000_000_000 +
            prizeStatistic.getOrDefault("2등", 0) * 30_000_000 +
            prizeStatistic.getOrDefault("3등", 0) * 1_500_000 +
            prizeStatistic.getOrDefault("4등", 0) * 50_000 +
            prizeStatistic.getOrDefault("5등", 0) * 5_000

    return (totalPrize.toDouble() / purchaseAmount) * 100
}

fun readAndValidatePurchaseAmount(): Int? {
    return try {
        println("구입금액을 입력해 주세요.")
        val amount = Console.readLine().toInt()
        require(amount % 1000 == 0) { "[ERROR] 로또는 1,000원 단위로만 구매할 수 있습니다." }
        amount
    } catch (e: NumberFormatException) {
        println("[ERROR] 유효한 숫자를 입력해 주세요.")
        null
    } catch (e: IllegalArgumentException) {
        println(e.message)
        null
    } catch (e: RuntimeException) {
        println("[ERROR] " + e.message)
        null
    }
}

fun readAndValidateWinningNumbers(): List<Int>? {
    return try {
        println("당첨 번호를 입력해 주세요.")
        val numbers = Console.readLine().split(",").map { it.trim().toInt() }
        require(numbers.size == 6 && numbers.all { it in 1..45 }) {
            "[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다."
        }
        numbers
    } catch (e: NumberFormatException) {
        println("[ERROR] 유효한 숫자를 입력해 주세요.")
        null
    } catch (e: IllegalArgumentException) {
        println(e.message)
        null
    } catch (e: RuntimeException) {
        println("[ERROR] " + e.message)
        null
    }
}

fun readAndValidateBonusNumber(winningNumbers: List<Int>): Int? {
    return try {
        println("보너스 번호를 입력해 주세요.")
        val bonus = Console.readLine().toInt()
        require(bonus in 1..45 && bonus !in winningNumbers) {
            "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며, 당첨 번호와 중복될 수 없습니다."
        }
        bonus
    } catch (e: NumberFormatException) {
        println("[ERROR] 유효한 숫자를 입력해 주세요.")
        null
    } catch (e: IllegalArgumentException) {
        println(e.message)
        null
    } catch (e: RuntimeException) {
        println("[ERROR] " + e.message)
        null
    }
}
