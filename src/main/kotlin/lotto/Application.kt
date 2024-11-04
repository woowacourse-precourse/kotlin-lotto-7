package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해 주세요.")
    val amount = readLine()?.toIntOrNull() ?: 0
    val lottoCount = amount / 1000

    println("\n${lottoCount}개를 구매했습니다.")
    val lottoTickets = generateLottoTickets(lottoCount)
    lottoTickets.forEach { println(it.sorted()) }
}

// 개수만큼 로또 발행
fun generateLottoTickets(count: Int): List<List<Int>> {
    val tickets = mutableListOf<List<Int>>()
    repeat(count) {
        tickets.add(generateLottoTicket())
    }
    return tickets
}

// 랜덤 로또 번호 생성
fun generateLottoTicket(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6).toList()
}
