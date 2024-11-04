package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val lottoBudget = getLottoBudget()
    val lottoTicketCount = getLottoTicketCount(lottoBudget)
    println("${lottoTicketCount}개를 구매했습니다.")

}

fun getLottoBudget(): Int {
    println("구입금액을 입력해 주세요.")
    val userInput = Console.readLine()
    val lottoBudget = userInput.toInt()
    if (lottoBudget % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요.")
    }
    return lottoBudget
}

fun getLottoTicketCount(lottoBudget: Int): Int {
    return lottoBudget/1000
}