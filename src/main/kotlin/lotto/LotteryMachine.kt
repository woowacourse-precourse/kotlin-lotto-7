package lotto

import camp.nextstep.edu.missionutils.Randoms

// 로또 발행, 당첨번호 추첨 기능
object LotteryMachine {
    fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }

    fun generateLottos(count: Int): List<Lotto> {
        return List(count) { generateLotto() }
    }
}