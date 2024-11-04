package lotto.model

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {
    fun issueLotto(purchaseAmount: PurchaseAmount): List<Lotto> {
        val lottoCount = purchaseAmount.getLottoCount()
        val lottos = mutableListOf<Lotto>()
        repeat(lottoCount) {
            lottos.add(
                Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)),
            )
        }
        return lottos
    }
}
