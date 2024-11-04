package lotto.model

import camp.nextstep.edu.missionutils.Randoms
class LottoStore: Store {
    override fun sell(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER ,LOTTO_MAX_NUMBER,LOTTO_NUMBER_COUNT)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_TICKET_PRICE = 1000
    }
}
