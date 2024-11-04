package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {

    enum class LottoRank(val matchCount: Int, val matchBonus: Boolean, val prize: Long, val displayText: String) {
        FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
        SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
        THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
        FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
        FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
        NONE(0, false, 0, "");

        companion object {
            fun valueOf(matchCount: Int, matchBonus: Boolean): LottoRank {
                return entries.find { it.matchCount == matchCount && it.matchBonus == matchBonus } ?: NONE
            }
        }
    }

    companion object {
        private const val ERROR_MESSAGE_PREFIX = "[ERROR]"

        fun runLotto() {
            val validLottoAmount = runWithRetry { readLottoAmount() }
            val lottos = generateLottoNumbers(validLottoAmount)

            println("당첨 번호를 입력해 주세요.")
            val validWinningNumber = runWithRetry { readWinningNumbers() }

            println("보너스 번호를 입력해 주세요.")
            val validBonusNumber = runWithRetry { readBonusNumber(validWinningNumber) }

            println("${validLottoAmount}개를 구매했습니다.")
            lottos.forEach { println(it.numbers) }

            val results = lottoRanks(lottos, validWinningNumber, validBonusNumber)
            extractedRank(results, validLottoAmount)
        }

        private fun <T> runWithRetry(action: () -> T): T {
            while (true) {
                try {
                    return action()
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        private fun readLottoAmount(): Int {
            println("구입 금액을 입력해 주세요.")
            val amount = Console.readLine()
            return checkLottoAmount(amount)
        }

        private fun checkLottoAmount(amount: String): Int {
            val lottoAmount = amount.toIntOrNull()
            return when {
                lottoAmount == null -> throw IllegalArgumentException("$ERROR_MESSAGE_PREFIX 구입 금액은 숫자여야 합니다.")
                lottoAmount < 0 -> throw IllegalArgumentException("$ERROR_MESSAGE_PREFIX 구입 금액은 양의 정수여야 합니다.")
                lottoAmount % 1000 != 0 -> throw IllegalArgumentException("$ERROR_MESSAGE_PREFIX 구입 금액은 1000원 단위여야 합니다.")
                else -> lottoAmount / 1000
            }
        }

        private fun readWinningNumbers(): List<Int> {
            val winningNumbers = Console.readLine()
            return checkWinningNumber(winningNumbers)
        }

        private fun checkWinningNumber(numbers: String): List<Int> {
            val winningNumbers = numbers.split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .map { it.toIntOrNull() ?: throw IllegalArgumentException("$ERROR_MESSAGE_PREFIX 당첨 번호는 숫자여야 합니다.") }

            require(winningNumbers.size == 6) { "$ERROR_MESSAGE_PREFIX 당첨 번호는 6자리의 숫자여야 합니다." }
            require(winningNumbers.all { it in 1..45 }) { "$ERROR_MESSAGE_PREFIX 당첨 번호는 1~45 사이의 숫자여야 합니다." }
            require(winningNumbers.toSet().size == 6) { "$ERROR_MESSAGE_PREFIX 당첨 번호는 중복될 수 없습니다." }
            return winningNumbers
        }

        private fun readBonusNumber(winningNumbers: List<Int>): Int {
            val bonusNumber = Console.readLine()
            return checkBonusNumber(bonusNumber, winningNumbers)
        }

        private fun checkBonusNumber(number: String, winningNumbers: List<Int>): Int {
            val bonusNumber = number.toIntOrNull()
                ?: throw IllegalArgumentException("$ERROR_MESSAGE_PREFIX 보너스 번호는 숫자여야 합니다.")
            require(bonusNumber in 1..45) { "$ERROR_MESSAGE_PREFIX 보너스 번호는 1~45 사이의 숫자여야 합니다." }
            require(bonusNumber !in winningNumbers) { "$ERROR_MESSAGE_PREFIX 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
            return bonusNumber
        }

        private fun generateLottoNumbers(amount: Int): List<Lotto> {
            return List(amount) {
                Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
            }
        }

        private fun lottoRanks(
            lottos: List<Lotto>,
            validWinningNumber: List<Int>,
            validBonusNumber: Int?,
        ): List<LottoRank> {
            return lottos.map { lotto ->
                val matchCount = lotto.numbers.count { it in validWinningNumber }
                val matchBonus = validBonusNumber != null && validBonusNumber in lotto.numbers
                LottoRank.valueOf(matchCount, matchBonus)
            }
        }

        private fun extractedRank(results: List<LottoRank>, validLottoAmount: Int) {
            val rankCounts = LottoRank.entries.associateWith { rank -> results.count { it == rank } }
            val totalPrize = rankCounts.entries.sumOf { (rank, count) -> rank.prize * count }
            val profitRate = (totalPrize.toDouble() / (validLottoAmount * 1000)) * 100

            println("당첨 통계")
            println("---")
            println("${LottoRank.FIFTH.displayText} - ${rankCounts[LottoRank.FIFTH] ?: 0}개")
            println("${LottoRank.FOURTH.displayText} - ${rankCounts[LottoRank.FOURTH] ?: 0}개")
            println("${LottoRank.THIRD.displayText} - ${rankCounts[LottoRank.THIRD] ?: 0}개")
            println("${LottoRank.SECOND.displayText} - ${rankCounts[LottoRank.SECOND] ?: 0}개")
            println("${LottoRank.FIRST.displayText} - ${rankCounts[LottoRank.FIRST] ?: 0}개")
            println("총 수익률은 ${"%.1f".format(profitRate)}%입니다.")
        }
    }
}