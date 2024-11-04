package lotto

import camp.nextstep.edu.missionutils.Console
import kotlin.random.Random

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
    for (lotto in lottos) {
        val (allMatchingNumber, isBonusMatched) = compareLottoNumbers(lottoWinningNumbers, lottoBonusNumber, lotto)
    }

}

fun getLottoBudget(): Int {
    println("구입금액을 입력해 주세요.")
    val userInput = Console.readLine()
    val lottoBudget = userInput.toInt()
    if (lottoBudget % LOTTO_TICKET_VALUE != 0) {
        throw IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요.")
    }
    return lottoBudget
}

fun getLottoTicketCount(lottoBudget: Int): Int {
    return lottoBudget / LOTTO_TICKET_VALUE
}

fun getLottoNumbers(): List<Int> {
    val lottoNumbers = List(LOTTO_NUMBER_COUNT) { Random.nextInt(1, 46) }
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
    val lottoNumbers: List<Int> = lotto.getLottoNumbers()
    val matchingNumbers = lottoWinningNumbers.intersect(lottoNumbers)
    val matchingCount = matchingNumbers.size
    val isBonusMatched: Int
    if (lottoBonusNumber in lottoNumbers) {
        isBonusMatched = 1
    }
    else {
        isBonusMatched = 0
    }
    val allMatchingNumber = matchingCount + isBonusMatched
    return Pair(allMatchingNumber, isBonusMatched)
}