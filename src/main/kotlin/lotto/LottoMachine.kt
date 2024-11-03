package lotto

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

    fun winningLotteryResult(
        lottos: List<Lotto>,
        bonusNumber: BonusNumber
    ): List<Pair<Int, Boolean>> {
        val winningNumber = bonusNumber.getWinningNumber()
        val bonus = bonusNumber.getBonusNumber()
        val result = lottos.map { lotto ->
            val lottoNumber = lotto.getLottoNumbers()
            val matchNumber = lottoNumber.count { it in winningNumber }
            val winningBonus = bonus in lottoNumber
            matchNumber to winningBonus
        }

        return result
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_MIN_NUM = 1
        const val LOTTO_MAX_NUM = 45
        const val LOTTO_COUNT = 6
    }
}