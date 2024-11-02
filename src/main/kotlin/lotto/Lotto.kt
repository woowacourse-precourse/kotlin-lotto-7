package lotto

import camp.nextstep.edu.missionutils.Console

enum class LottoPrice(price: Int) {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000)
}


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
