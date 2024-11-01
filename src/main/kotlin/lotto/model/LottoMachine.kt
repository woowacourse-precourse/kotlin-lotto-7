package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.LOTTO_NUMBER_SIZE
import lotto.util.Constants.LOTTO_PRICE

class LottoMachine {

    fun purchaseLottos(purchaseAmount: Int): List<Lotto> {
        val issueCount = calculateIssueCount(purchaseAmount)
        val lottos = mutableListOf<Lotto>()

        repeat(issueCount) {
            val newLotto = generateLotto()
            lottos.add(newLotto)
        }

        return lottos
    }

    private fun calculateIssueCount(purchaseAmount: Int): Int = purchaseAmount / LOTTO_PRICE

    private fun generateLotto(): Lotto {
        val numbers = generateUniqueNumbers()
        return Lotto(numbers)
    }

    private fun generateUniqueNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_SIZE)
}