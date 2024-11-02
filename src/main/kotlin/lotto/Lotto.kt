package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    private var bonusNumber = 0
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }
    fun drawLotto() {
        while (true) {
            try {
                val randomNumber = Randoms.pickNumberInRange(1, 45)
                require(!numbers.contains(bonusNumber)) { "[ERROR] 보너스 번호는 기존 번호와 중복될 수 없습니다." }
                bonusNumber = randomNumber
                break
            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }


}
