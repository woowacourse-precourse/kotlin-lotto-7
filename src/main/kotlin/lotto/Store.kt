package lotto

import camp.nextstep.edu.missionutils.Randoms

object Store {
    //fun buyLotto(money: Int)

    fun generateLotto(): Lotto {
        var numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        while (numbers.distinct().size != numbers.size){
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        }
        val lotto = Lotto(numbers.sorted())
        return lotto
    }
}