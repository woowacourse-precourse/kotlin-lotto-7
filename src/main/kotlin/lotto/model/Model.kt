package lotto.model

import camp.nextstep.edu.missionutils.Randoms

fun randomNums(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1,45,6)
}

fun generateLottoTickets(count: Int): List<Lotto> {
    return List(count) { Lotto(randomNums()) }
}

