package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoNumberGenerator : NumberGenerator {
    override fun generateNumber(min: Int, max: Int, count: Int): List<Int> {
        return Randoms.pickUniqueNumbersInRange(min, max, count).sorted()
    }
}
