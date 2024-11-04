package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT) {
            println("[ERROR] 로또 번호는 ${LOTTO_COUNT}개여야 합니다.")
            throw IllegalArgumentException ("[ERROR] 로또 번호는 ${LOTTO_COUNT}개여야 합니다.") }
        require(numbers.groupingBy { it }.eachCount().all { 1==it.value }) {
            println(exceptionMessageDuplicate)
            throw IllegalArgumentException (exceptionMessageDuplicate)
        }
        showNumbers()
    }

    constructor() : this(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER,LOTTO_COUNT))

    private fun showNumbers(){
        println(numbers.sorted().joinToString(separator = ", ", prefix = "[", postfix = "]"))
    }

    fun getNumbers() : List<Int>{
        return numbers
    }

    companion object {
        const val LOTTO_COUNT = 6
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45

        val exceptionMessageDuplicate = "[ERROR] 중복된 숫자가 존재하면 안 됩니다."
    }
}
