package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun generate(): Lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))

    fun generateLottos(count: Int): Lottos {
        val lottos = mutableListOf<Lotto>()
        repeat(count) {
            lottos.add(generate())
        }
        return Lottos(lottos)
    }
}