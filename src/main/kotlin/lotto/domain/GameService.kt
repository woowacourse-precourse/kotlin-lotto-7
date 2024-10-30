package template.domain

import lotto.model.Lotto
import camp.nextstep.edu.missionutils.Randoms

class GameService {
    fun buyLotto(money: Long): List<Lotto> {
        val lottoAmount = (money / ONE_LOTTO_PRICE).toInt()

        return List(lottoAmount) { generateLotto() }
    }

    private fun generateLotto(): Lotto {
        val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        lottoNumbers.sort()

        return Lotto(lottoNumbers)
    }

    companion object {
        private const val ONE_LOTTO_PRICE = 1000
    }
}