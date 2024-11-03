package lotto

fun main() {
    val money = inputMoney()
    val tickets = calculateTicket(money)
    println("$tickets 개를 구매했습니다.")
    val lottoNum = inputLottoNumbers()

    val bonusNum = inputBonusNumber(lottoNum)

    repeat(tickets) {
        generateLotto(tickets)
    }

}


fun calculateTicket(money: Int): Int {
    return money / 1000
}

fun generateLotto(ticketsCount : Int) : List<Lotto> {
    return List(ticketsCount) { Lotto(Lotto.generateLotto()) }
}
