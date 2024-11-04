package lotto.model

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45
    private const val LOTTO_SIZE = 6;

    fun issueLotto(purchaseAmount: PurchaseAmount): List<Lotto> {
        val lottoCount = purchaseAmount.getLottoCount()
        val lottos = mutableListOf<Lotto>()
        repeat(lottoCount) {
            lottos.add(
                Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE))
            )
        }
        return lottos
    }
}
