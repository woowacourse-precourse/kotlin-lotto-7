package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoController {

    val lottos = ArrayList<Lotto>()

    fun startLotto() {
        val lottoView = LottoView()
        val buyLottoAmount = divideLottoPrice(lottoView.getBuyAmount())
        releaseLotto(buyLottoAmount)
        lottoView.showBoughtLotto(buyLottoAmount, lottos)
        val winnerNumber = lottoView.getWinnerNumber()
        val specialNumber = lottoView.getSpecialNumber(winnerNumber)
        val lottoResult = calculateLotto(winnerNumber, specialNumber)
        lottoView.showLottoResult(lottoResult)
        lottoView.showReturnRate(getReturnRate(lottoResult, buyLottoAmount))
    }

    private fun getReturnRate(lottoResult: List<Int>, buyLottoAmount: Int): Double {
        var sum = 0.0
        sum += LottoResult.THREE.prize * lottoResult[0]
        sum += LottoResult.FOUR.prize * lottoResult[1]
        sum += LottoResult.FIVE.prize * lottoResult[2]
        sum += LottoResult.FIVE_SPECIAL.prize * lottoResult[3]
        sum += LottoResult.SIX.prize * lottoResult[4]
        return sum / (buyLottoAmount * Constant.LOTTO_PRICE) * 100
    }

    private fun calculateLotto(winnerNumber: List<Int>, specialNumber: Int): List<Int> {
        val lottoResult = MutableList(5) { 0 }
        lottos.forEach {
            when (it.getLottoValue().toSet().minus(winnerNumber.toSet()).size) {
                3 -> lottoResult[0]++
                2 -> lottoResult[1]++
                1 -> {
                    if (it.getLottoValue().contains(specialNumber)) lottoResult[3]++
                    else lottoResult[2]++
                }

                0 -> lottoResult[4]++
            }
        }
        return lottoResult
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
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}