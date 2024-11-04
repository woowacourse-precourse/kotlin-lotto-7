package lotto

import camp.nextstep.edu.missionutils.Console

const val LOTTO_TICKET_VALUE = 1000
const val LOTTO_NUMBER_COUNT = 6

fun main() {
    val lottoBudget = getLottoBudget()
    val lottoTicketCount = getLottoTicketCount(lottoBudget)
    println("${lottoTicketCount}개를 구매했습니다.")
    val lottos: MutableList<Lotto> = mutableListOf()
    for (i in 1..lottoTicketCount) {
        val lottoNumbers = getLottoNumbers()
        val lotto = Lotto(lottoNumbers)
        lottos.add(lotto)
    }
    for (lotto in lottos) {
        println(lotto)
    }
    val lottoWinningNumbers = getLottoWinningNumbers()
    val lottoBonusNumber = getLottoBonusNumber(lottoWinningNumbers)
    val lottoResults: MutableList<Pair<Int, Int>> = mutableListOf()
    for (lotto in lottos) {
        val lottoResult = compareLottoNumbers(lottoWinningNumbers, lottoBonusNumber, lotto)
        lottoResults.add(lottoResult)
    }
    val lottoMoney = mutableMapOf(
        "3개 일치" to 5000,
        "4개 일치" to 50000,
        "5개 일치" to 1500000,
        "5개 일치, 보너스 볼 일치" to 30000000,
        "6개 일치" to 2000000000
    )
    val matchCounts = mutableMapOf(
        "3개 일치" to 0,
        "4개 일치" to 0,
        "5개 일치" to 0,
        "5개 일치, 보너스 볼 일치" to 0,
        "6개 일치" to 0
    )

    for ((matchCount, bonusMatchCount) in lottoResults) {
        val allMatchCount = matchCount + bonusMatchCount
        when {
            allMatchCount == 6 -> matchCounts["6개 일치"] = matchCounts["6개 일치"]!! + 1
            allMatchCount == 5 && bonusMatchCount == 1 -> matchCounts["5개 일치, 보너스 볼 일치"] = matchCounts["5개 일치, 보너스 볼 일치"]!! + 1
            allMatchCount == 5 -> matchCounts["5개 일치"] = matchCounts["5개 일치"]!! + 1
            allMatchCount == 4 -> matchCounts["4개 일치"] = matchCounts["4개 일치"]!! + 1
            allMatchCount == 3 -> matchCounts["3개 일치"] = matchCounts["3개 일치"]!! + 1
        }
    }
    printResult(lottoMoney, matchCounts)
    val totalMoney = calculateTotalMoney(lottoMoney, matchCounts)
    val profitRate = calculateProfitRate(totalMoney, lottoBudget)
    printProfitRate(profitRate)
}

fun getLottoBudget(): Int {
    try {
        println("구입금액을 입력해 주세요.")
        val userInput = Console.readLine()
        val lottoBudget = userInput.toInt()
        if (lottoBudget % LOTTO_TICKET_VALUE != 0) {
            throw IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요.")
        }
        return lottoBudget
    } catch(e: java.lang.IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    }

    return getLottoBudget()
}

fun getLottoTicketCount(lottoBudget: Int): Int {
    return lottoBudget / LOTTO_TICKET_VALUE
}

fun getLottoNumbers(): List<Int> {
    val lottoNumbers = (1..45).shuffled().take(6)
    return lottoNumbers
}

fun getLottoWinningNumbers(): List<Int> {
    try {
        println("당첨 번호를 입력해 주세요.")
        val userInput = Console.readLine()
        val lottoWinningNumbers = userInput.split(",").map { it.toInt() ?: throw IllegalArgumentException("당첨 번호는 쉼표(,)로 구분된 1~45 사이의 정수 형태로 입력해 주세요.") }
        if (lottoWinningNumbers.size != LOTTO_NUMBER_COUNT) {
            throw IllegalArgumentException("당첨 번호는 6개로 입력해 주세요.")
        }
        if (!lottoWinningNumbers.all { it in 1..45}) {
            throw IllegalArgumentException("당첨 번호는 1~45 사이의 숫자로 입력해 주세요.")
        }
        if (lottoWinningNumbers.size != lottoWinningNumbers.distinct().size) {
            throw IllegalArgumentException("당첨 번호는 중복되지 않은 숫자로 입력해 주세요.")
        }
        return lottoWinningNumbers
    } catch(e: java.lang.IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    }

    return getLottoWinningNumbers()
}

fun getLottoBonusNumber(lottoWinningNumbers: List<Int>): Int {
    try {
        println("보너스 번호를 입력해 주세요.")
        val userInput = Console.readLine()
        val lottoBonusNumber = userInput.toInt()
        if (!(lottoBonusNumber in 1..45)) {
            throw IllegalArgumentException("당첨 번호는 1~45 사이의 숫자로 입력해 주세요.")
        }
        if (lottoBonusNumber in lottoWinningNumbers) {
            throw IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않은 숫자로 입력해 주세요.")
        }
        return lottoBonusNumber
    } catch (e: java.lang.IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    }
    return getLottoBonusNumber(lottoWinningNumbers)
}

fun compareLottoNumbers(lottoWinningNumbers: List<Int>, lottoBonusNumber: Int, lotto: Lotto): Pair<Int, Int> {
    val matchingCount = lotto.countMatchingNumbers(lottoWinningNumbers)
    val bonusMatchingCount = if (lotto.isBonusMatched(lottoBonusNumber)) 1 else 0
    return Pair(matchingCount, bonusMatchingCount)
}

fun printResult(lottoMoney: Map<String, Int>, matchCounts: Map<String, Int>) {
    println("당첨 통계")
    println("---")

    val matchLabels = listOf(
        "3개 일치",
        "4개 일치",
        "5개 일치",
        "5개 일치, 보너스 볼 일치",
        "6개 일치"
    )

    matchLabels.forEach { label ->
        val prize = String.format("%,d", lottoMoney[label] ?: 0)
        val count = matchCounts[label] ?: 0
        println("$label (${prize}원) - ${count}개")
    }
}


fun calculateTotalMoney(lottoMoney: MutableMap<String, Int>, matchCounts: MutableMap<String, Int>): Int {
    var totalMoney = 0
    for ((key, count) in matchCounts) {
        val prize = lottoMoney[key] ?: 0
        totalMoney += prize * count
    }
    return totalMoney
}

fun calculateProfitRate(totalMoney: Int, lottoBudget: Int): Double {
    if (lottoBudget == 0) return 0.0
    return (totalMoney.toDouble() / lottoBudget) * 100
}

fun printProfitRate(profitRate: Double) {
    println("총 수익률은 ${profitRate}%입니다.")
}