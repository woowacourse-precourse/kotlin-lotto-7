package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val payment: String) {

    private val lottoGenerator = LottoGenerator()
    private val lottoCount = calculateTotalLottoCount()
    
    val lottoList = makeLotto()

    private fun calculateTotalLottoCount(): Int {
        return payment.toInt() / LOTTO_PRICE
    }

    private fun makeLotto(): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        repeat(lottoCount) {
            lottoList.add(lottoGenerator.generateLotto())
        }
        return lottoList.toList()
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_MIN_NUM = 1
        const val LOTTO_MAX_NUM = 45
        const val LOTTO_COUNT = 6
    }
}