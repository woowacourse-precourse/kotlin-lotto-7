package lotto

import camp.nextstep.edu.missionutils.Randoms

object Store {
    fun buyLotto(money: Int): List<Lotto> {
        val numberOfLottoPurchased = money/1000
        val purchasedLottos = mutableListOf<Lotto>()
        repeat(numberOfLottoPurchased){
            purchasedLottos.add(generateLotto())
        }
        return purchasedLottos
    }

    fun generateLotto(): Lotto {
        var numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        while (numbers.distinct().size != numbers.size){
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        }
        val lotto = Lotto(numbers.sorted())
        return lotto
    }
}