package lotto.controller

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.model.Lotto
import lotto.model.LottoTotalMatchResult
import lotto.validation.InputValidation
import lotto.view.Input
import lotto.view.Output

class LottoController(val input: Input, val output: Output) {
    private val lottos: MutableList<Lotto> = mutableListOf()
    private val validator = InputValidation()

    private fun getLottoTicketCount(amount: Int): Int {
        return amount / 1000
    }

    private fun createRandomLotto(): Lotto {
        return Lotto(pickUniqueNumbersInRange(1, 45, 6).sorted())
    }

    private fun createResult(): List<Int> {
        val numbers = input.getLottoNumbers()
        val bonusNumbers = input.getLottoBonusNumber()
        val resultNumbers: MutableList<Int> = mutableListOf()

        repeat(numbers.size) {
            resultNumbers.add(numbers[it])
        }
        resultNumbers.add(bonusNumbers)

        return validator.lottoNumbersNotDuplicate(resultNumbers.toList())
    }

    private fun calculateTotalMatchResult(result: List<Int>): LottoTotalMatchResult {
        val totalMatchResult = LottoTotalMatchResult()
        repeat(lottos.size) { idx ->
            val matchResult = lottos[idx].calculateMatchResult(result)
            when (matchResult.matchNumbersCount) {
                6 -> totalMatchResult.prizeCount1 += 1
                5 -> if (matchResult.isMatchBonus) totalMatchResult.prizeCount2 += 1 else totalMatchResult.prizeCount3 += 1
                4 -> totalMatchResult.prizeCount4 += 1
                3 -> totalMatchResult.prizeCount5 += 1
            }
        }
        return totalMatchResult
    }

    private fun calculateRateOfReturn(totalMatchResult: LottoTotalMatchResult, amount: Int): Float {
        return String.format("%.1f", totalMatchResult.getTotalPrize() / amount).toFloat()
    }

    fun runMachine() {
        val amount = input.getPurchaseAmount()
        val count = getLottoTicketCount(amount)
        repeat(count) {
            val lotto: Lotto = createRandomLotto()
            lottos.add(lotto)
        }

        output.printLottoNumbers(lottos)

        val result = createResult()
        val totalMatchResult = calculateTotalMatchResult(result)
        val rateOfReturn = calculateRateOfReturn(totalMatchResult, amount)
        output.printTotalLottoPrize(totalMatchResult, rateOfReturn)
    }
}