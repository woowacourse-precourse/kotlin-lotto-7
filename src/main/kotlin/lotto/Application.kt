package lotto

fun main() {
    val money = inputMoney()
    val tickets = calculateTicket(money)
    println("$tickets 개를 구매했습니다.")
    val lottoNum = inputLottoNumbers()

    val bonusNum = inputBonusNumber(lottoNum)

    repeat(tickets) {
        val generateLotto = Lotto.generateLotto()
        println(generateLotto)
    }

}

