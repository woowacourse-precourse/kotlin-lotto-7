package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoPaper {
    val paperNumber: List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)

    fun printNumber() {
        println(paperNumber)
    }


}