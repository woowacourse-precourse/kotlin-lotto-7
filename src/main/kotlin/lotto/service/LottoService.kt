package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constants.LOTTO_SIZE
import lotto.constants.Constants.MAX_NUMBER
import lotto.constants.Constants.MIN_NUMBER
import lotto.model.Lotto

class LottoService {
    fun generateLottoList(count: Int): List<Lotto> {
        val lottoList = List(count) {
            val newNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
            Lotto(newNumbers)
        }

        return lottoList
    }
}