package lotto.Controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.Model.Lotto

fun generateLottos(count: Int): List<Lotto> {
    return List(count) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        Lotto(numbers)
    }
}