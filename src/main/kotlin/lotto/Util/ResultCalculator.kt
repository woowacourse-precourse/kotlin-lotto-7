package lotto.Util

import lotto.Controller.LotteryMachine
import lotto.Model.Lotto
import lotto.Model.User

// 등수별로 당첨된 로또의 개수와 당첨금을 User에게 기록
class ResultCalculator {
    // User가 보유한 로또 티켓을 바탕으로 당첨 결과를 계산하여 반환
    fun calculateResults(user: User): Map<Prize, Int> {
        val results = mutableMapOf<Prize, Int>()
        user.purchasedLottos.forEach { lotto ->
            processLottoPrize(lotto, results, user)
        }
        return results
    }

    // 로또 티켓 하나에 대한 당첨 결과를 처리
    private fun processLottoPrize(lotto: Lotto, results: MutableMap<Prize, Int>, user: User) {
        val matchCount = lotto.getNumbers().intersect(LotteryMachine.winningNumbers.toSet()).size
        val isBonusMatched = LotteryMachine.bonusNumber in lotto.getNumbers()

        // Prize 등수를 결정
        Prize.getPrize(matchCount, isBonusMatched)?.let {
            results[it] = results.getOrDefault(it, 0) + 1
            user.addProfit(it.prizeMoney)
        }
    }

    // User의 수익률을 계산
    fun calculateProfitRate(user: User): Double {
        val totalSpent = user.purchasedLottoCount * 1000 // 로또 구매에 사용한 총 금액
        return if (totalSpent > 0) (user.profit.toDouble() / totalSpent) * 100 else 0.0
    }
}