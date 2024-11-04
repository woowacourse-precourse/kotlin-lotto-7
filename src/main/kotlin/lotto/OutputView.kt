package lotto

import camp.nextstep.edu.missionutils.Randoms

fun lottoNumberPrint(purchase_money: Int): MutableList<List<Int>> {
    var lotto_num = MutableList<List<Int>>(purchase_money) { emptyList() }
    val PURCHASE_NUM_MESSAGE = "개를 구매했습니다."

    println("\n$purchase_money$PURCHASE_NUM_MESSAGE")
    for (lotto: Int in 0..<(purchase_money)) {
        lotto_num[lotto] = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        println(lotto_num[lotto])
    }
    return lotto_num
}

fun resultoutput(purchase_money: Int, lottoNumber: MutableList<List<Int>>, winnerNumber: List<Int>, bonusNumber: Int) {
    val WINNING_STATICS_MESSAGE = "당첨 통계\n---"
    println("\n$WINNING_STATICS_MESSAGE")
    winnerresult(purchase_money, lottoNumber, winnerNumber, bonusNumber)
}

fun resultprint(purchase_money: Int, scoreBoard: MutableList<Int>, fiveBonusCount: Int) {
    for (winning in Winning.values()) {
        val count = if (winning.bonus == 1) fiveBonusCount else scoreBoard[winning.count]
        val bonusMessage = if (winning.bonus == 1) ", 보너스 볼 일치" else ""
        println("${winning.count}개 일치 (${winning.prizestring}원)$bonusMessage - ${count}개")
    }
}

enum class Winning(val count: Int, val prizestring: String, val bonus: Int, val prize: Int) {
    Fifth(3, "5,000", 0, 5000),
    Fourth(4, "50,000", 0, 50000),
    Third(5, "1,500,000", 0, 1500000),
    Second(5, "30,000,000", 1, 30000000),
    First(6, "2,000,000,000", 0, 2000000000);
}
