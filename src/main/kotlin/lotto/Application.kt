package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val LOTTO_TICKET_VALUE = 1000
const val LOTTO_NUMBER_COUNT = 6

enum class LottoMatch(val label: String, val prize: Int) {
    MATCH_3("3개 일치", 5000),
    MATCH_4("4개 일치", 50000),
    MATCH_5("5개 일치", 1500000),
    MATCH_5_BONUS("5개 일치, 보너스 볼 일치", 30000000),
    MATCH_6("6개 일치", 2000000000);

    companion object {
        fun initMatchCounts(): MutableMap<LottoMatch, Int> {
            return values().associateWith { 0 }.toMutableMap()
        }
    }
}

fun main() {
    val lottoBudget = getLottoBudget()
    val lottoTicketCount = getLottoTicketCount(lottoBudget)
    printTicketCount(lottoTicketCount)
    val lottos: MutableList<Lotto> = getLottoNumbers(lottoTicketCount)
    printLottoNumbers(lottos)
    val lottoWinningNumbers = getLottoWinningNumbers()
    val lottoBonusNumber = getLottoBonusNumber(lottoWinningNumbers)
    val lottoResults: MutableList<Pair<Int, Int>> = mutableListOf()
    for (lotto in lottos) {
        val lottoResult = compareLottoNumbers(lottoWinningNumbers, lottoBonusNumber, lotto)
        lottoResults.add(lottoResult)
    }
    val matchCounts = LottoMatch.initMatchCounts()
    countLottoNumber(lottoResults, matchCounts)
    printResult(matchCounts)
    val totalMoney = calculateTotalMoney(matchCounts)
    val profitRate = calculateProfitRate(totalMoney, lottoBudget)
    printProfitRate(profitRate)
}

private fun countLottoNumber(lottoResults: MutableList<Pair<Int, Int>>, matchCounts: MutableMap<LottoMatch, Int>) {
    for ((matchCount, bonusMatchCount) in lottoResults) {
        when {
            matchCount == 6 -> matchCounts[LottoMatch.MATCH_6] = matchCounts[LottoMatch.MATCH_6]!! + 1
            matchCount == 5 && bonusMatchCount == 1 -> matchCounts[LottoMatch.MATCH_5_BONUS] = matchCounts[LottoMatch.MATCH_5_BONUS]!! + 1
            matchCount == 5 -> matchCounts[LottoMatch.MATCH_5] = matchCounts[LottoMatch.MATCH_5]!! + 1
            matchCount == 4 -> matchCounts[LottoMatch.MATCH_4] = matchCounts[LottoMatch.MATCH_4]!! + 1
            matchCount == 3 -> matchCounts[LottoMatch.MATCH_3] = matchCounts[LottoMatch.MATCH_3]!! + 1
        }
    }
}

private fun printLottoNumbers(lottos: MutableList<Lotto>) {
    for (lotto in lottos) {
        println(lotto)
    }
}

private fun getLottoNumbers(lottoTicketCount: Int): MutableList<Lotto> {
    val lottos: MutableList<Lotto> = mutableListOf()
    for (i in 1..lottoTicketCount) {
        val lottoNumbers = getLottoNumbers()
        val lotto = Lotto(lottoNumbers)
        lottos.add(lotto)
    }
    return lottos
}

private fun printTicketCount(lottoTicketCount: Int) {
    println("${lottoTicketCount}개를 구매했습니다.")
}

fun getLottoBudget(): Int {
    try {
        println("구입금액을 입력해 주세요.")
        val userInput = Console.readLine()
        val lottoBudget = userInput.toInt()
        handleBudgetInputError(lottoBudget, userInput)
        return lottoBudget
    } catch(e: java.lang.IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    }

    return getLottoBudget()
}

private fun handleBudgetInputError(lottoBudget: Int, userInput: String) {
    if (lottoBudget % LOTTO_TICKET_VALUE != 0) {
        throw IllegalArgumentException("로또 구입 금액은 1,000원 단위로 입력해 주세요.")
    }
    if (!userInput.matches(Regex("\\d+"))) {
        throw IllegalArgumentException("입력 값은 숫자만 포함해야 합니다.")
    }
}

fun getLottoTicketCount(lottoBudget: Int): Int {
    return lottoBudget / LOTTO_TICKET_VALUE
}

fun getLottoNumbers(): List<Int> {
    val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER_COUNT).toList()
    return lottoNumbers
}

fun getLottoWinningNumbers(): List<Int> {
    try {
        println("당첨 번호를 입력해 주세요.")
        val userInput = Console.readLine()
        val lottoWinningNumbers = userInput.split(",").map { it.toInt() ?: throw IllegalArgumentException("당첨 번호는 쉼표(,)로 구분된 1~45 사이의 정수 형태로 입력해 주세요.") }
        handleWinningNumberInputError(lottoWinningNumbers)
        return lottoWinningNumbers
    } catch(e: java.lang.IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    }

    return getLottoWinningNumbers()
}

private fun handleWinningNumberInputError(lottoWinningNumbers: List<Int>) {
    if (lottoWinningNumbers.size != LOTTO_NUMBER_COUNT) {
        throw IllegalArgumentException("당첨 번호는 6개로 입력해 주세요.")
    }
    if (!lottoWinningNumbers.all { it in 1..45 }) {
        throw IllegalArgumentException("당첨 번호는 1~45 사이의 숫자로 입력해 주세요.")
    }
    if (lottoWinningNumbers.size != lottoWinningNumbers.distinct().size) {
        throw IllegalArgumentException("당첨 번호는 중복되지 않은 숫자로 입력해 주세요.")
    }
}

fun getLottoBonusNumber(lottoWinningNumbers: List<Int>): Int {
    try {
        println("보너스 번호를 입력해 주세요.")
        val userInput = Console.readLine()
        val lottoBonusNumber = userInput.toInt()
        HandleBonusInputError(lottoBonusNumber, lottoWinningNumbers)
        return lottoBonusNumber
    } catch (e: java.lang.IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    }
    return getLottoBonusNumber(lottoWinningNumbers)
}

private fun HandleBonusInputError(lottoBonusNumber: Int, lottoWinningNumbers: List<Int>) {
    if (!(lottoBonusNumber in 1..45)) {
        throw IllegalArgumentException("당첨 번호는 1~45 사이의 숫자로 입력해 주세요.")
    }
    if (lottoBonusNumber in lottoWinningNumbers) {
        throw IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않은 숫자로 입력해 주세요.")
    }
}

fun compareLottoNumbers(lottoWinningNumbers: List<Int>, lottoBonusNumber: Int, lotto: Lotto): Pair<Int, Int> {
    val matchingCount = lotto.countMatchingNumbers(lottoWinningNumbers)
    val bonusMatchingCount = if (lotto.isBonusMatched(lottoBonusNumber)) 1 else 0
    return Pair(matchingCount, bonusMatchingCount)
}

fun printResult(matchCounts: Map<LottoMatch, Int>) {
    println("당첨 통계")
    println("---")

    LottoMatch.values().forEach { match ->
        val prize = String.format("%,d", match.prize)
        val count = matchCounts[match] ?: 0
        println("${match.label} (${prize}원) - ${count}개")
    }
}

fun calculateTotalMoney(matchCounts: MutableMap<LottoMatch, Int>): Int {
    var totalMoney = 0
    for ((match, count) in matchCounts) {
        totalMoney += match.prize * count
    }
    return totalMoney
}

fun calculateProfitRate(totalMoney: Int, lottoBudget: Int): Double {
    if (lottoBudget == 0) return 0.0
    return (totalMoney.toDouble() / lottoBudget) * 100
}

fun printProfitRate(profitRate: Double) {
    println("총 수익률은 ${String.format("%.1f", profitRate)}%입니다.")
}