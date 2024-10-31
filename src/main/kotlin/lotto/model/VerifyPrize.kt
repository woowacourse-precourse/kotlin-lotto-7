package lotto.model

class VerifyPrize {
    val countPrize: MutableMap<PrizeNumber, Int> = mutableMapOf()
    private var earn: Double = INIT_EARN

    init {
        PrizeNumber.entries.forEach { rank -> countPrize[rank] = INIT_RANK_COUNT }
    }

    fun prizeResult(tickets: List<List<Int>>, prizeNumber: List<Int>, bonusNumber: Int): Double {
        tickets.forEach { ticket ->
            checkPrize(ticket, prizeNumber, bonusNumber)
        }
        return earn / (tickets.size * LOTTO_PRICE) * PERCENTAGE
    }

    private fun checkPrize(ticket: List<Int>, prizeNumber: List<Int>, bonusNumber: Int) {
        val theNumber = ticket.count { prizeNumber.contains(it) }
        val rank = when (theNumber) {
            CORRECT_THREE -> PrizeNumber.FIFTH
            CORRECT_FOUR -> PrizeNumber.FOURTH
            CORRECT_FIVE -> {
                if (prizeNumber.contains(bonusNumber)) {
                    PrizeNumber.SECOND
                }
                else {
                    PrizeNumber.THIRD
                }
            }
            CORRECT_SIX -> PrizeNumber.FIRST
            else -> PrizeNumber.THE_LAST
        }
        countPrize[rank] = countPrize[rank]!! + ADD_ONE
        earn += rank.prizeValue
    }

    companion object {
        private const val INIT_EARN = 0.0
        private const val INIT_RANK_COUNT = 0
        private const val LOTTO_PRICE = 1000
        private const val PERCENTAGE = 100
        private const val CORRECT_THREE = 3
        private const val CORRECT_FOUR = 4
        private const val CORRECT_FIVE = 5
        private const val CORRECT_SIX = 6
        private const val ADD_ONE = 1
    }
}