package lotto

import camp.nextstep.edu.missionutils.Randoms

class Store {
    var numberOfLottoPurchased: Int = 0
    val purchasedLottos = mutableListOf<Lotto>()

    fun buyLotto(money: Int): List<Lotto> {
        numberOfLottoPurchased = money / 1000
        repeat(numberOfLottoPurchased) {
            purchasedLottos.add(generateLotto())
        }
        return purchasedLottos
    }

    fun generateLotto(): Lotto {
        var numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        while (numbers.distinct().size != numbers.size) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        }
        val lotto = Lotto(numbers.sorted())
        return lotto
    }
}