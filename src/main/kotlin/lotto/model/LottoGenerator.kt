package lotto.model

class LottoGenerator {
    private val lottoes = mutableListOf<Lotto>()
    fun makeLotto(money: Int) {
        val random = Random()
        repeat(money / 1000) {
            lottoes.add(Lotto(random.generate()))
        }
    }

    fun getLottoes(): List<Lotto> {
        return lottoes
    }
}