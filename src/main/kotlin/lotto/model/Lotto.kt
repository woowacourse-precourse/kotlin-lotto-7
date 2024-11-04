package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun randomNums(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1,45,6)
    }

}
