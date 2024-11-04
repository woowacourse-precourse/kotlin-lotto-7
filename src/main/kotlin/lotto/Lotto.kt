package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 로또 번호는 중복일 수 없습니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호의 범위는 1 ~ 45입니다." }
    }

    fun issueLotto(number: Int): List<List<Int>> {
        return (1..number).map {
            Randoms.pickUniqueNumbersInRange(1, 45, 6)
        }
    }

}
