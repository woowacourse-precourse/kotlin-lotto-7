package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val input = Input()
    val output = Output()
    val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    output.outPutMoney()
    input.inputMoney()
}

