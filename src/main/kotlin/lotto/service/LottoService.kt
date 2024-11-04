package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.model.MatchType
import lotto.util.Constants.LOTTO_PRICE_UNIT
import java.math.BigDecimal
import java.math.RoundingMode

class LottoService(
    private val lottoCounterService: LottoCounterService,
    private val lottoMatchService: LottoMatchService
) {

    private var _userLottoNumbers: MutableList<Lotto> = mutableListOf()
    val userLottoNumbers: List<Lotto> get() = _userLottoNumbers

    fun generateUserLottoNumbers(count: Int) {
        repeat(count) {
            _userLottoNumbers.add(Lotto(generateRandomNumber()))
        }
    }

    private fun generateRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, RANDOM_COUNT).sortedBy { it }
    }

    fun setUserLottoNumbers(numbers: List<Lotto>) {
        _userLottoNumbers = numbers.toMutableList()
    }

    companion object {
        const val START_INCLUSIVE = 1
        const val END_INCLUSIVE = 45
        const val RANDOM_COUNT = 6
    }
}