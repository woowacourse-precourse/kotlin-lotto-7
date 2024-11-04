package lotto.Service

import lotto.Lotto
import lotto.model.WinningNumber
import lotto.view.OutputView.OutputWinningStatistics

class CalculationWinningStatistics(
    buyLottoNumbers: List<Lotto>,
    winningNumbers: WinningNumber,
    amount: Int
) {
    private val lotto = buyLottoNumbers
    private val winningNumber = winningNumbers
    private var profit = 0
    private val matchingNumbersCountList = mutableListOf<String>()
    private val matchingNumbersList = MutableList(5) { 0 }
    private val amount = amount

    fun calculation() {

        for (lotto in lotto) {
            val matchingNumbers =
                lotto.getNumbers().intersect(winningNumber.getNumbers().take(6)).size
            val bonusStatus = checkBonus(lotto, matchingNumbers)
            matchingNumbersCountList.add(bonusStatus)
        }

        return statsCalculation(matchingNumbersCountList)
    }

    fun checkBonus(lotto: Lotto, matchingNumbers: Int): String {

        return if (matchingNumbers == 5 && lotto.getNumbers()
                .contains(winningNumber.getNumbers()[6])
        ) {
            "보너스"
        } else {
            matchingNumbers.toString()
        }
    }

    fun statsCalculation(matchingNumbersCountList: MutableList<String>) {
        for (count in matchingNumbersCountList) {
            if (count.contains("3")) profit += 5000
            if (count.contains("4")) profit += 50000
            if (count.contains("보너스")) profit += 30000000
            if (count.contains("5")) profit += 1500000
            if (count.contains("6")) profit += 2000000000

        }
        addStats()
        val yield = String.format("%.2f", yieldCalculation()).toDouble()
        return OutputWinningStatistics(matchingNumbersList, yield)
    }

    fun addStats() {
        for (count in matchingNumbersCountList) {
            if (count.contains("3")) ++matchingNumbersList[0]
            if (count.contains("4")) ++matchingNumbersList[1]
            if (count.contains("보너스")) ++matchingNumbersList[2]
            if (count.contains("5")) ++matchingNumbersList[3]
            if (count.contains("6")) ++matchingNumbersList[4]
        }
    }

    fun yieldCalculation(): Double {
        return (profit.toDouble() / amount.toDouble()) * 100
    }

}