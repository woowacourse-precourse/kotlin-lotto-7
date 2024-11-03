package lotto.model

class LotteryGenerator {
    private val lotteries = mutableListOf<Lotto>()
    fun makeLotto(money: Int) {
        val random = Random()
        repeat(money / 1000) {
            lotteries.add(Lotto(random.generateSixNumber()))
        }
    }

    fun getLotteries(): List<Lotto> {
        return lotteries
    }
}