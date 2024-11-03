package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.NumberFormatException

const val LOTTO_PRICE = 1000
const val FIRST_PRIZE = 2_000_000_000
const val SECOND_PRIZE = 30_000_000
const val THIRD_PRIZE = 1_500_000
const val FOURTH_PRIZE = 50_000
const val FIFTH_PRIZE = 5_000
const val DEFAULT_PRIZE = 0

enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST(6, FIRST_PRIZE),
    SECOND(5, SECOND_PRIZE),
    THIRD(5, THIRD_PRIZE),
    FOURTH(4, FOURTH_PRIZE),
    FIFTH(3, FIFTH_PRIZE),
    NONE(0, DEFAULT_PRIZE);

    companion object {
        fun of(matchCount: Int, bonusMatch: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && bonusMatch -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}

fun main() {
    val purchaseAmount = readAndValidatePurchaseAmount() ?: return
    val numberOfLottos = purchaseAmount / LOTTO_PRICE
    val lottos = List(numberOfLottos) {
        Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
    }
    println("${numberOfLottos}개를 구매했습니다.")
    lottos.forEach { println(it) }

    val winningNumbers = readAndValidateWinningNumbers() ?: return
    val bonusNumber = readAndValidateBonusNumber(winningNumbers) ?: return

    val prizeStatistic = lottos.groupingBy { lotto ->
        Rank.of(lotto.countMatchingNumbers(winningNumbers), lotto.containsBonusNumber(bonusNumber))
    }.eachCount()

    displayPrizeStatistics(prizeStatistic)
    val profitRate = calculateProfitRate(prizeStatistic, purchaseAmount)
    println("총 수익률은 ${"%.1f".format(profitRate)}%입니다.")
}

fun displayPrizeStatistics(prizeStatistic: Map<Rank, Int>) {
    println("당첨 통계\n---")
    println("3개 일치 (5,000원) - ${prizeStatistic.getOrDefault(Rank.FIFTH, 0)}개")
    println("4개 일치 (50,000원) - ${prizeStatistic.getOrDefault(Rank.FOURTH, 0)}개")
    println("5개 일치 (1,500,000원) - ${prizeStatistic.getOrDefault(Rank.THIRD, 0)}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${prizeStatistic.getOrDefault(Rank.SECOND, 0)}개")
    println("6개 일치 (2,000,000,000원) - ${prizeStatistic.getOrDefault(Rank.FIRST, 0)}개")
}

fun calculateProfitRate(prizeStatistic: Map<Rank, Int>, purchaseAmount: Int): Double {
    val totalPrize = prizeStatistic.entries.sumOf { (rank, count) -> rank.prize * count }
    return (totalPrize.toDouble() / purchaseAmount) * 100
}

fun readAndValidatePurchaseAmount(): Int? {
    return try {
        println("구입금액을 입력해 주세요.")
        val amount = Console.readLine().toInt()
        require(amount % LOTTO_PRICE == 0) { "[ERROR] 로또는 ${LOTTO_PRICE}원 단위로만 구매할 수 있습니다." }
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
