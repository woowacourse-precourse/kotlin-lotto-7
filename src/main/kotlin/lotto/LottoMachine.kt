package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun releaseLotto(money: Int): List<Lotto> {
        val releaseCount = money.calculateLottoCount()

        println("${releaseCount}개를 구매했습니다.")

        val lottos = arrayListOf<Lotto>()

        repeat(releaseCount) {
            lottos.add(createLotto())
        }

        return lottos
    }

    private fun Int.calculateLottoCount(): Int {
        return this / lottoPrice
    }

    private fun createLotto(): Lotto = Lotto(drawNumbers())

    fun lottoRank(
        numbers: List<Int>,
        winningNumbers: List<Int>,
        bonus: Int
    ): Rank {
        validateWinningInformation(winningNumbers, bonus)

        val normalWinningNumberGroup = winningNumbers.toSet()
        val winningNumberMatchCount = countNormalNumberMatch(numbers, normalWinningNumberGroup)
        var bonusMatch = false

        for (number in numbers) {
            if (number == bonus) {
                bonusMatch = true; break
            }
        }

        return calculateRank(winningNumberMatchCount, bonusMatch)
    }

    private fun calculateRank(winningNumberMatchCount: Int, bonusMatch: Boolean): Rank {
        return when (winningNumberMatchCount) {
            6 -> {
                Rank.FIRST
            }

            5 -> {
                if (bonusMatch) {
                    return Rank.SECOND
                }
                return Rank.THIRD
            }

            4 -> {
                Rank.FORTH
            }

            3 -> {
                Rank.FIFTH
            }

            else -> {
                Rank.LOSE
            }
        }
    }

    private fun validateWinningInformation(
        winningNumbers: List<Int>,
        bonusNumber: Int
    ) {
        if (winningNumbers.size != 6) {
            throw IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개여야 합니다.")
        }
        val usedNumber = mutableSetOf<Int>()
        val allNumbers = listOf(*winningNumbers.toTypedArray(), bonusNumber)

        for (number in allNumbers) {
            if (!numberRangeValidate(number)) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1 이상 45 이하여야 합니다.")
            }
            if (!numberDuplicateValidate(number, usedNumber)) {
                throw IllegalArgumentException("[ERROR] 중복된 로또 당첨 번호입니다.")
            }

            usedNumber.add(number)
        }
    }

    private fun countNormalNumberMatch(
        numbers: List<Int>,
        winningNumbers: Set<Int>
    ): Int {
        var count = 0

        for (number in numbers) {
            if (winningNumbers.contains(number)) {
                count++
            }
        }

        return count
    }

    private fun numberRangeValidate(number: Int): Boolean {
        return number in 1..45
    }

    private fun numberDuplicateValidate(
        number: Int,
        usedNumber: Set<Int>
    ): Boolean {
        return !usedNumber.contains(number)
    }

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