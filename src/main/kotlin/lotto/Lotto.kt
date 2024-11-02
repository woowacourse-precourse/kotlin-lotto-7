package lotto

import camp.nextstep.edu.missionutils.Console

class Lotto(private val numbers: List<Int>) {
    private var bonusNumber = 0

    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun inputBonus() {
        bonusNumber = Console.readLine().toIntOrNull() ?: throw (IllegalArgumentException("[ERROR] 숫자가 아닙니다. "))
    }


    // TODO: 추가 기능 구현
}
