package lotto

import camp.nextstep.edu.missionutils.Randoms

fun lottoNumberPrint(purchase_money: Int): MutableList<List<Int>> {
    var lotto_num = MutableList<List<Int>>(purchase_money) { emptyList() }
    val PURCHASE_NUM_MESSAGE = "개를 구입했습니다."

    println("\n$purchase_money$PURCHASE_NUM_MESSAGE")
    for (i: Int in 0..<(purchase_money)) {
        lotto_num[i] = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        println(lotto_num[i])
    }
    return lotto_num
}
