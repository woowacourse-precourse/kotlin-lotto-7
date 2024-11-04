package lotto

import lotto.utils.LottoGenerator

class LottoMachine(
    money: Int,
) {

    val lottoSet: List<Lotto> = createLottoSet(money)

    private fun createLottoSet(money: Int): List<Lotto> {
        val lottoCount = LottoGenerator.getLottoCount(money)
        val lottoSet = List(lottoCount) {
            Lotto(LottoGenerator.createLotto())
        }
        return lottoSet
    }

}