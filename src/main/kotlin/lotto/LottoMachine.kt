package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.roundToLong

class LottoMachine(private val purchaseAmount: Int) {
    private val lottoList: List<Lotto>

    init {
        require(purchaseAmount > 0 && purchaseAmount % Lotto.PRICE == 0) { "[ERROR] 로또 구입 금액은 ${Lotto.PRICE}의 배수여야 합니다." }
        lottoList = List(purchaseAmount / Lotto.PRICE) { Lotto(randomNumbers()) }
    }

    private fun randomNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LENGTH)

    fun receipt(): String = "${lottoList.size}개를 구매했습니다.\n${lottoList.joinToString("\n")}\n"
    fun result(numbers: List<Int>, bonusNumber: Int): String {
        val sb = StringBuilder("당첨 통계\n---\n")
        val rankCount = IntArray(prizeArr.size)
        lottoList.forEach { lotto -> (lotto.matchCount(numbers) to lotto.isMatch(bonusNumber)).let { if (it in rankMap) rankCount[rankMap[it]!!]++ } }
        for (i in (rankCount.size - 1) downTo 0) {
            sb.appendLine("${resultPrefix[i]}${rankCount[i]}${resultSuffix[i]}")
        }
        val totalAmount = rankCount.indices.sumOf { rankCount[it].toLong() * prizeArr[it] }
        val rate = (totalAmount.toDouble() * 1000 / purchaseAmount).roundToLong() / 10.0
        sb.appendLine("총 수익률은 ${rate}%입니다.")
        return sb.toString()
    }

    companion object {
        private val rankMap = mapOf(
            (Lotto.LENGTH to true) to 0,
            (Lotto.LENGTH to false) to 0,
            ((Lotto.LENGTH - 1) to true) to 1,
            ((Lotto.LENGTH - 1) to false) to 2,
            ((Lotto.LENGTH - 2) to true) to 3,
            ((Lotto.LENGTH - 2) to false) to 3,
            ((Lotto.LENGTH - 3) to true) to 4,
            ((Lotto.LENGTH - 3) to false) to 4,
        )
        private val prizeArr = intArrayOf(2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000)
        private val resultPrefix = arrayOf(
            "6개 일치 (2,000,000,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "4개 일치 (50,000원) - ",
            "3개 일치 (5,000원) - "
        )
        private val resultSuffix = arrayOf("개", "개", "개", "개", "개")
    }
}