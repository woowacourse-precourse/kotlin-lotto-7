package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.ValidatorUtil.validateLottoSize

class Lotto(private val numbers: List<Int>) {
    init {
        validateLottoSize(numbers.size)
    }

    companion object {
        fun generate(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            return Lotto(numbers)
        }
    }

    fun getNumbers(): List<Int> = numbers

}
