package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoShop() {
    fun sellLotto(need: Int): ArrayList<Lotto> {
        val lottos = ArrayList<Lotto>()
        for (i in 1..need) {
            lottos.add(makeLotto())
        }
        return lottos
    }

    private fun makeLotto(): Lotto{
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        numbers.sort()
        return Lotto(numbers)
    }
}