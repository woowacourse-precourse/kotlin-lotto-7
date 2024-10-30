package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {

    init {
        val checkAlreadyUseNumber = mutableSetOf<Int>()
        var isNotDuplicate = true

        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.fold(true) { result, number ->
            isNotDuplicate = isNotDuplicate && !checkAlreadyUseNumber.contains(number)
            checkAlreadyUseNumber.add(number)

            result && number in 1..45
        }) { "[ERROR] 로또 번호는 1과 45 사이여야 합니다." }
        require(isNotDuplicate) { "[ERROR] 로또 번호는 중복될 수 없습니다." }
    }

    // TODO: 추가 기능 구현
}
