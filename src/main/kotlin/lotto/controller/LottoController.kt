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
    private val totalMatchResult = LottoTotalMatchResult()

    private fun getLottoTicketCount(): Int {
        return input.getPurchaseAmount() / 1000
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

    private fun calculateTotalMatchResult(result: List<Int>) {
        repeat(lottos.size) { idx ->
            val matchResult = lottos[idx].calculateMatchResult(result)
            when (matchResult.matchNumbersCount) {
                1 -> totalMatchResult.prize1 += 1
                2 -> if (matchResult.isMatchBonus) totalMatchResult.prize2 += 1
                3 -> totalMatchResult.prize3 += 1
                4 -> totalMatchResult.prize4 += 1
                5 -> totalMatchResult.prize5 += 1
            }
        }
    }
}