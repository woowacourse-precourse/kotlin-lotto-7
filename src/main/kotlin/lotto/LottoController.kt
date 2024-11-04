package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.LottoView

class LottoController {

    val lottos = ArrayList<Lotto>()

    fun startLotto() {
        val lottoView = LottoView()
        val buyLottoAmount = divideLottoPrice(lottoView.getBuyAmount())
        releaseLotto(buyLottoAmount)
        lottoView.showBoughtLotto(buyLottoAmount, lottos)
    }

    private fun divideLottoPrice(inputBuyAmount: Int): Int {
        return inputBuyAmount / Constant.LOTTO_PRICE
    }

    private fun releaseLotto(buyLottoAmount: Int) {
        repeat(buyLottoAmount) {
            lottos.add(Lotto(getLottoNumber()))
        }
    }

    private fun getLottoNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}