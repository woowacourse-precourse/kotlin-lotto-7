package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoNumberGenerator : LottoNumberGenerator {

    override fun generateNumbers(): Lotto {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(randomNumbers.sorted())
    }

}