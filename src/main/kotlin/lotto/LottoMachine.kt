package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun createLotto(): Lotto = Lotto(drawNumbers())

    private fun drawNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(1, 45, 6)

    enum class Rank(
        val winningPrice: Int,
        val description: String
    ) {
        FIRST(2000000000, "6개 일치"),
        SECOND(30000000, "5개 일치, 보너스 볼 일치"),
        THIRD(1500000, "5개 일치"),
        FORTH(50000, "4개 일치"),
        FIFTH(5000, "3개 일치"),
        LOSE(0, "낙첨")
    }
}