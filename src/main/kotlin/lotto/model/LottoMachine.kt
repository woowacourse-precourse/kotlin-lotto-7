package lotto.model

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {

    fun issueLotto(purchaseAmount: PurchaseAmount): List<Lotto> {
        val lottoCount = purchaseAmount.getLottoCount()
        val lottos = mutableListOf<Lotto>()
        repeat(lottoCount) {
            lottos.add(
                Lotto(Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LOTTO_SIZE))
            )
        }
        return lottos
    }
}
