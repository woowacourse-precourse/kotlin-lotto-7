package lotto.controller

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.Lotto
import lotto.validation.InputValidation
import lotto.view.Input

class LottoController(val input: Input) {
    private val validator = InputValidation()

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

}