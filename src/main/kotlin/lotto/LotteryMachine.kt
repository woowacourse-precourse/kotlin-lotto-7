package lotto

import camp.nextstep.edu.missionutils.Randoms

// 로또 발행, 당첨번호 관리
object LotteryMachine {
    private val winningNumbers = mutableListOf<Int>()
    private var bonusNumber: Int = 0

    fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }

    fun generateLottos(count: Int): List<Lotto> {
        return List(count) { generateLotto() }
    }

    fun setWinningLotto(newWinningNumbers: List<Int>, newbonusNumber: Int) {
        winningNumbers.clear()
        winningNumbers.addAll(newWinningNumbers)
        bonusNumber = newbonusNumber
    }
}