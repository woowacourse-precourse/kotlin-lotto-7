package model

import utils.validator.Validator
import utils.validator.WinningNumbersValidator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        WinningNumbersValidator.SHOULD_NOT_BE_DUPLICATE.validate(
            numbers.map { it.toString() }.toList()
        )

    }

    fun matchCount(winningLotto: WinningLotto): Int {
        return numbers.intersect(winningLotto.lotto.numbers).size
    }

    fun isMatchBonus(winningLotto: WinningLotto): Boolean {
        return numbers.contains(winningLotto.bonusNumber)
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }
}
