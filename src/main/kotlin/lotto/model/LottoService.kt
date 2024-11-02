package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants

class LottoService {
    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            Constants.LOTTO_NUMBER_MIN,
            Constants.LOTTO_NUMBER_MAX,
            Constants.LOTTO_NUMBERS_SIZE
        )
    }

    fun generateLottoTickets(count: Int): List<Lotto> {
        return List(count) { Lotto(generateLottoNumbers()) }
    }
}