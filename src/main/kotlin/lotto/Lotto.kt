package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == 6) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
    }

    companion object {
        fun generateNumbers(): List<Int> {
            return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        }
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
