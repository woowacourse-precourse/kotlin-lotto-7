package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.ValidatorUtil.validateLottoSize
import lotto.util.ValidatorUtil.validateUniqueLottoNumbers

class Lotto(private val numbers: List<Int>) {
    init {
        validateLottoSize(numbers.size)
        validateUniqueLottoNumbers(numbers)
    }

    companion object {
        fun generate(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            return Lotto(numbers)
        }
    }

    fun match(winningNumbers: List<Int>, bonusNumber: Int): LottoRank {
        val matchCount = numbers.count { it in winningNumbers }
        val bonusMatch = bonusNumber in numbers
        return LottoRank.fromMatchCount(matchCount, bonusMatch)
    }

    fun getNumbers(): List<Int> = numbers

}
