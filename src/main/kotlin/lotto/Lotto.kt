package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {ErrorMessage.LOTTO_SIZE_ERROR.message }
        require(numbers.toSet().size == 6) {ErrorMessage.LOTTO_DUPLICATION_ERROR.message}
        require(numbers.all { it in 1..45 }) {ErrorMessage.LOTTO_RANGE_ERROR.message}

    }

    companion object{
        fun generateLotto(): List<Int> {
            return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        }
    }
}
