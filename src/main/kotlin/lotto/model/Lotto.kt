package lotto.model
import lotto.util.ValidatorUtil.validateLottoSize

class Lotto(private val numbers: List<Int>) {
    init {
        validateLottoSize(numbers.size)
    }
}
