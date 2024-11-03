package lotto

// 등수별로 당첨된 로또의 개수와 당첨금을 User에게 기록
class ResultCalculator {
    // User가 보유한 로또 티켓을 바탕으로 당첨 결과를 계산
    fun calculateResults(user: User): Map<Prize, Int> {
        val results = mutableMapOf<Prize, Int>()
        user.lottoList.forEach { lotto ->
            val matchCount = lotto.getNumbers().intersect(LotteryMachine.winningNumbers.toSet()).size
            val isBonusMatched = LotteryMachine.bonusNumber in lotto.getNumbers()

            // Prize 등수를 결정
            Prize.getPrize(matchCount, isBonusMatched)?.let {
                results[it] = results.getOrDefault(it, 0) + 1
                user.addProfit(it.prizeMoney)
            }
        }
        return results
    }
}