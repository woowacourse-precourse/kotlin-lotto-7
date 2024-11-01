package lotto.model

import lotto.util.Constants.EXCEPTION_PREFIX
import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.LOTTO_NUMBER_SIZE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { EXCEPTION_PREFIX + "로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == numbers.size) { EXCEPTION_PREFIX + "중복된 로또 번호가 없어야 합니다." }
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) { EXCEPTION_PREFIX + "로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    fun getLottoNumbers(): List<Int> = numbers.sorted()
}
