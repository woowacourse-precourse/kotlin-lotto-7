package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 당첨 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 당첨 번호는 1~45 사이의 숫자여야 합니다." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] 로또 당첨 번호는 중복될 수 없습니다." }
    }

    enum class LottoRank(val matchCount: Int, val matchBonus: Boolean, val prize: Long, val displayText: String) {
        FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
        SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
        THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
        FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
        FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
        NONE(0, false, 0, "");

        companion object {
            fun valueOf(matchCount: Int, matchBonus: Boolean): LottoRank {
                return values().find { it.matchCount == matchCount && it.matchBonus == matchBonus } ?: NONE
            }
        }
    }
    companion object {
        private fun checkLottoAmount(amount: String): Int {
            val lottoAmount = amount.toIntOrNull()
            when {
                lottoAmount == null -> throw IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.")
                lottoAmount < 0 -> throw IllegalArgumentException("[ERROR] 구입 금액은 양의 정수여야 합니다.")
                lottoAmount % 1000 != 0 -> throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.")
                else -> return lottoAmount / 1000
            }
        }

        private fun checkWinningNumber(numbers: String): List<Int> {
            val winningNumbers = if ("," in numbers) {
                numbers.split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .map { it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.")}
            } else { throw IllegalArgumentException("[ERROR] 당첨 번호는 ','를 이용하여 구분하여야 합니다.\n[예시] 1,2,3,4,5,6")}

            when {
                winningNumbers.size != 6 -> throw IllegalArgumentException("[ERROR] 당첨 번호는 6자리의 숫자여야 합니다.")
                winningNumbers.any { it !in 1..45} -> throw IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.")
                winningNumbers.size != winningNumbers.toSet().size -> throw IllegalArgumentException("[ERROR] 당첨 번호는 중복을 허용하지 않습니다.")
            }
            return winningNumbers
        }

        private fun checkBonusNumber(number: String, winningNumber: List<Int>): Int? {
            val bonusNumber = number.toIntOrNull()

            when {
                bonusNumber == null -> throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")
                bonusNumber !in 1..45 -> throw IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.")
                bonusNumber in winningNumber -> throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
            }
            return bonusNumber
        }

        private fun generateLottoNumbers(amount: Int): List<Lotto> {
            return List(amount) {
                val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
                Lotto(lottoNumbers)
            }
        }

        private fun extractedRank(results: List<LottoRank>, validLottoAmount: Int) {
            val rankCounts = LottoRank.values().associateWith { rank -> results.count { it == rank } }
            val totalPrize = rankCounts.entries.sumOf { (rank, count) -> rank.prize * count }
            val profitRate = (totalPrize.toDouble() / (validLottoAmount * 1000))

            println("당첨 통계")
            println("---")
            println("${LottoRank.FIFTH.displayText} - ${rankCounts[LottoRank.FIFTH]}개")
            println("${LottoRank.FOURTH.displayText} - ${rankCounts[LottoRank.FOURTH]}개")
            println("${LottoRank.THIRD.displayText} - ${rankCounts[LottoRank.THIRD]}개")
            println("${LottoRank.SECOND.displayText} - ${rankCounts[LottoRank.SECOND]}개")
            println("${LottoRank.FIRST.displayText} - ${rankCounts[LottoRank.FIRST]}개")
            println("총 수익률은 ${"%.1f".format(profitRate)}%입니다.")
        }

        private fun lottoRanks(
            lottos: List<Lotto>,
            validWinningNumber: List<Int>,
            validBonusNumber: Int?,
        ): List<LottoRank> {
            val results = lottos.map { lotto ->
                val matchCount = lotto.numbers.count { it in validWinningNumber }
                val matchBonus = validBonusNumber != null && validBonusNumber in lotto.numbers
                LottoRank.valueOf(matchCount, matchBonus)
            }
            return results
        }
        fun runLotto() {
            println("구입 금액을 입력해 주세요.")
            val lottoAmount = Console.readLine()
            var validLottoAmount = checkLottoAmount(lottoAmount)

            println("당첨 번호를 입력해 주세요.")
            val winningNumbers = Console.readLine()
            val validWinningNumber = checkWinningNumber(winningNumbers)

            println("보너스 번호를 입력해 주세요.")
            val bonusNumber = Console.readLine()
            val validBonusNumber = checkBonusNumber(bonusNumber, validWinningNumber)

            println("${validLottoAmount}개를 구매했습니다.")
            val lottos = generateLottoNumbers(validLottoAmount)
            lottos.forEach { println(it.numbers) }

            val results = lottoRanks(lottos, validWinningNumber, validBonusNumber)
            extractedRank(results, validLottoAmount)
        }
    }
}
