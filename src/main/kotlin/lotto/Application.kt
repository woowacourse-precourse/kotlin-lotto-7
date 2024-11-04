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