package lotto.model

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {

    fun issueLottos(purchaseAmount: PurchaseAmount): List<Lotto> {
        val lottoCount = purchaseAmount.getLottoCount()
        val lottos = mutableListOf<Lotto>()
        repeat(lottoCount) {
            lottos.add(
                Lotto(Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, Lotto.LOTTO_SIZE))
            )
        }
        return lottos
    }
}
