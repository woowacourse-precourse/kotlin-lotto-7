package lotto.domain.generator

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.domain.WinningLotto

class LottoGenerator {
    private fun generate(): Lotto {
        val numbers =
            Randoms.pickUniqueNumbersInRange(
                Lotto.MINIMUM_NUMBER,
                Lotto.MAXIMUM_NUMBER,
                Lotto.LOTTO_SIZE,
            )
        return Lotto(numbers)
    }

    fun generateWinningLotto(): WinningLotto {
        val numbers =
            Randoms.pickUniqueNumbersInRange(
                Lotto.MINIMUM_NUMBER,
                Lotto.MAXIMUM_NUMBER,
                Lotto.LOTTO_SIZE + 1,
            )
        return WinningLotto(numbers.take(Lotto.LOTTO_SIZE), numbers.last())
    }

    fun createLottos(money: Int): List<Lotto> {
        require(money > 0) { sendError(LOTTO_MONEY_ERROR) }
        require(money % Lotto.PRICE == 0) { sendError(LOTTO_UNIT_ERROR) }

        val count = money / Lotto.PRICE
        return List(count) { generate() }
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR] "
        const val LOTTO_MONEY_ERROR = "구입 금액은 0보다 커야 합니다."
        const val LOTTO_UNIT_ERROR = "구입 금액은 1,000원 단위여야 합니다."

        fun sendError(message: String): String = ERROR_PREFIX + message
    }
}
