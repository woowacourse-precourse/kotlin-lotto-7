package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object LottoConfig {
    const val LOTTO_PRICE = 1000
    const val LOTTO_NUMBER_COUNT = 6
    const val MIN_NUMBER = 1
    const val MAX_NUMBER = 45
}

object Message {
    const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    const val INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
    const val ERROR_INVALID_AMOUNT = "구입 금액은 1,000원 단위여야 합니다."
    const val ERROR_INVALID_MINIMUM_AMOUNT = "구입 금액은 1,000원 이상이어야 합니다."
    const val ERROR_INVALID_WINNING_NUMBERS = "당첨 번호는 중복되지 않는 6개의 숫자여야 합니다."
    const val ERROR_INVALID_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_INVALID_BONUS_NUMBER = "보너스 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_INVALID_NUMBER_FORMAT = "숫자만 입력 가능합니다."
    const val ERROR_DUPLICATE_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복될 수 없습니다."
    const val RESULT_HEADER = "\n당첨 통계\n---"
    const val RESULT_FORMAT = "%s (%,d원) - %d개"
    const val PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다."
}

object PrizeConfig {
    const val FIRST_PRIZE = 2_000_000_000
    const val SECOND_PRIZE = 30_000_000
    const val THIRD_PRIZE = 1_500_000
    const val FOURTH_PRIZE = 50_000
    const val FIFTH_PRIZE = 5_000
}

object MatchConfig {
    const val FIRST_MATCH = 6
    const val SECOND_MATCH = 5
    const val THIRD_MATCH = 5
    const val FOURTH_MATCH = 4
    const val FIFTH_MATCH = 3
    const val NO_MATCH = 0
}

object RankDescription {
    const val FIRST = "6개 일치"
    const val SECOND = "5개 일치, 보너스 볼 일치"
    const val THIRD = "5개 일치"
    const val FOURTH = "4개 일치"
    const val FIFTH = "3개 일치"
    const val NONE = ""
}

enum class Rank(
    val matchCount: Int,
    val prize: Int,
    val description: String,
    val needBonusMatch: Boolean = false
) {
    FIRST(
        MatchConfig.FIRST_MATCH,
        PrizeConfig.FIRST_PRIZE,
        RankDescription.FIRST
    ),
    SECOND(
        MatchConfig.SECOND_MATCH,
        PrizeConfig.SECOND_PRIZE,
        RankDescription.SECOND,
        true
    ),
    THIRD(
        MatchConfig.THIRD_MATCH,
        PrizeConfig.THIRD_PRIZE,
        RankDescription.THIRD
    ),
    FOURTH(
        MatchConfig.FOURTH_MATCH,
        PrizeConfig.FOURTH_PRIZE,
        RankDescription.FOURTH
    ),
    FIFTH(
        MatchConfig.FIFTH_MATCH,
        PrizeConfig.FIFTH_PRIZE,
        RankDescription.FIFTH
    ),
    NONE(
        MatchConfig.NO_MATCH,
        0,
        RankDescription.NONE
    )
}

class LottoGame {
    fun start() {
        val purchaseAmount = getPurchaseAmount()

    }

    private fun getPurchaseAmount(): Int {
        println(Message.INPUT_PURCHASE_AMOUNT)
        return readValidAmount()
    }

    private fun readValidAmount(): Int {
        while (true) {
            try {
                val input = Console.readLine()
                validateInputNumber(input)
                val amount = input.toInt()
                validateAmount(amount)
                return amount
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    private fun validateInputNumber(input: String) {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Message.ERROR_INVALID_NUMBER_FORMAT)
        }
    }

    fun validateAmount(amount: Int) {
        require(amount >= LottoConfig.LOTTO_PRICE) {
            Message.ERROR_INVALID_MINIMUM_AMOUNT
        }
        require(amount % LottoConfig.LOTTO_PRICE == 0) {
            Message.ERROR_INVALID_AMOUNT
        }
    }

    private fun printPurchaseResult(lottos: List<Lotto>) {
        println("\n${lottos.size}개를 구매했습니다.")
        for (lotto in lottos) {
            println(lotto.getNumbers())
        }
    }

    private fun getWinningNumbers(): Set<Int> {
        println(Message.INPUT_WINNING_NUMBERS)
        return readValidWinningNumbers()
    }

    private fun readValidWinningNumbers(): Set<Int> {
        while (true) {
            try {
                val input = Console.readLine()
                validateInputNumbers(input)
                val numbers = parseWinningNumbers(input)
                validateWinningNumbers(numbers)
                return numbers
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    private fun validateInputNumbers(input: String) {
        val numbers = input.split(",")
        for (number in numbers) {
            validateInputNumber(number.trim())
        }
    }

    private fun parseWinningNumbers(input: String): Set<Int> {
        val numbers = mutableSetOf<Int>()
        val splitNumbers = input.split(",")
        for (number in splitNumbers) {
            numbers.add(number.trim().toInt())
        }
        return numbers
    }

    private fun validateWinningNumbers(numbers: Set<Int>) {
        require(numbers.size == LottoConfig.LOTTO_NUMBER_COUNT) {
            Message.ERROR_INVALID_WINNING_NUMBERS
        }
        validateWinningNumbersRange(numbers)
    }

    private fun validateWinningNumbersRange(numbers: Set<Int>) {
        for (number in numbers) {
            require(number in LottoConfig.MIN_NUMBER..LottoConfig.MAX_NUMBER) {
                Message.ERROR_INVALID_NUMBER_RANGE
            }
        }
    }

    private fun getBonusNumber(winningNumbers: Set<Int>): Int {
        println(Message.INPUT_BONUS_NUMBER)
        return readValidBonusNumber(winningNumbers)
    }

    private fun readValidBonusNumber(winningNumbers: Set<Int>): Int {
        while (true) {
            try {
                val input = Console.readLine()
                validateInputNumber(input)
                val number = input.toInt()
                validateBonusNumber(number)
                validateBonusNumberDuplicate(number, winningNumbers)
                return number
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    private fun validateBonusNumber(number: Int) {
        require(number in LottoConfig.MIN_NUMBER..LottoConfig.MAX_NUMBER) {
            Message.ERROR_INVALID_BONUS_NUMBER
        }
    }

    fun validateBonusNumberDuplicate(bonusNumber: Int, winningNumbers: Set<Int>) {
        require(!winningNumbers.contains(bonusNumber)) {
            Message.ERROR_DUPLICATE_BONUS_NUMBER
        }
    }

    private fun calculateResults(
        lottos: List<Lotto>,
        winningNumbers: Set<Int>,
        bonusNumber: Int
    ): Map<Rank, Int> {
        val resultMap = mutableMapOf<Rank, Int>()
        for (lotto in lottos) {
            val rank = calculateRank(lotto, winningNumbers, bonusNumber)
            val count = resultMap.getOrDefault(rank, 0)
            resultMap[rank] = count + 1
        }
        return resultMap.toMap()
    }

    private fun calculateRank(lotto: Lotto, winningNumbers: Set<Int>, bonusNumber: Int): Rank {
        val matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers)
        val hasBonus = isContainsBonusNumber(lotto.getNumbers(), bonusNumber)
        return determineRank(matchCount, hasBonus)
    }

    private fun countMatchingNumbers(numbers: List<Int>, winningNumbers: Set<Int>): Int {
        var count = 0
        for (number in numbers) {
            if (winningNumbers.contains(number)) {
                count++
            }
        }
        return count
    }

    private fun isContainsBonusNumber(numbers: List<Int>, bonusNumber: Int): Boolean {
        for (number in numbers) {
            if (number == bonusNumber) return true
        }
        return false
    }

    private fun determineRank(matchCount: Int, hasBonus: Boolean): Rank {
        return when (matchCount) {
            6 -> Rank.FIRST
            5 -> if (hasBonus) Rank.SECOND else Rank.THIRD
            4 -> Rank.FOURTH
            3 -> Rank.FIFTH
            else -> Rank.NONE
        }
    }
}

fun main() {
    LottoGame().start()
}