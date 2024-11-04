package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoPaper {
    var paperNumber: List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)

    init {
        paperNumber = paperNumber.sorted()
    }

    fun printNumber() {
        println(paperNumber)
    }


}