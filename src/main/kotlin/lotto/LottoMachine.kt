package lotto

class LottoMachine(private val payment: String) {

    private val lottoGenerator = LottoGenerator()
    private val lottoCount = calculateTotalLottoCount()
    private val prize = Prize()

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

    fun countPrize(prizeList: List<Pair<Int, Boolean>>): Map<Rank?, Int> {
        val rank = prizeList.groupingBy {
            Rank.matchRankInfo(it.first, it.second)
        }.eachCount()

        return rank
    }

    fun getWinningMessage(rank: Map<Rank?, Int>): List<String> {
        val winningMessage = mutableListOf<String>()
        rank.forEach { (rank, count) ->
            rank?.let { prize.countPrize(it) }
        }
        winningMessage.add(FIFTH_PRIZE_RESULT.format(prize.fifth))
        winningMessage.add(FORTH_PRIZE_RESULT.format(prize.fourth))
        winningMessage.add(THIRD_PRIZE_RESULT.format(prize.third))
        winningMessage.add(SECOND_PRIZE_RESULT.format(prize.second))
        winningMessage.add(FIRST_PRIZE_RESULT.format(prize.first))

        return winningMessage
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_MIN_NUM = 1
        const val LOTTO_MAX_NUM = 45
        const val LOTTO_COUNT = 6

        const val FIFTH_PRIZE_RESULT = "3개 일치 (5,000원) - %d개"
        const val FORTH_PRIZE_RESULT = "4개 일치 (50,000원) - %d개"
        const val THIRD_PRIZE_RESULT = "5개 일치 (1,500,000원) - %d개"
        const val SECOND_PRIZE_RESULT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
        const val FIRST_PRIZE_RESULT = "6개 일치 (2,000,000,000원) - %d개"
    }
}