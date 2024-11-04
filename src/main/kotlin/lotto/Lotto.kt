package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT) { "[ERROR] 로또 번호는 ${LOTTO_COUNT}개여야 합니다." }
        showNumbers()
    }

    constructor() : this(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER,LOTTO_COUNT))

    private fun showNumbers(){
        println(numbers.sorted().joinToString(separator = ",", prefix = "[", postfix = "]"))
    }
    companion object {
        const val LOTTO_COUNT = 6
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
