package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import lotto.util.InputParser.parseNumericInput
import lotto.util.InputParser.parseWinningNumbers
import lotto.util.InputValidator.validateBonusNumberDistinctness
import lotto.util.InputValidator.validateLottoNumberInRange
import lotto.util.InputValidator.validateMoneyIsNotNegative
import lotto.util.InputValidator.validateMoneyIsEnough
import lotto.util.InputValidator.validateMoneyIsDivisible
import lotto.util.InputValidator.validateWinningNumbersCount
import lotto.util.InputValidator.validateWinningNumbersDistinctness

class InputTest : NsTest() {
    @ParameterizedTest
    @ValueSource(strings = ["", "abc"])
    fun `숫자로 변환될 수 없는 문자열이 입력된 경우 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> { parseNumericInput(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,a", ",,,,,", "1,2,,4,5,6", ",1,2,3,4,"])
    fun `당첨 번호 중 숫자로 변환될 수 없는 문자열이 있을 경우 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> { parseWinningNumbers(input) }
    }

    @Test
    fun `구매 금액이 음수일 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { validateMoneyIsNotNegative(-1000) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 100])
    fun `구매 금액으로 로또를 하나도 구매할 수 없을 경우 발생한다`(input: Int) {
        assertThrows<IllegalArgumentException> { validateMoneyIsEnough(input) }
    }

    @Test
    fun `구매 금액이 로또의 가격으로 나누어 떨어지지 않을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { validateMoneyIsDivisible(1001) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7"])
    fun `당첨 번호가 6개가 아닐 경우 예외가 발생한다`(input: String) {
        val numbers = parseWinningNumbers(input)
        assertThrows<IllegalArgumentException> { validateWinningNumbersCount(numbers) }
    }

    @Test
    fun `당첨 번호 중 중복되는 것이 있을 경우 예외가 발생한다`() {
        val numbers = parseWinningNumbers("1,1,1,1,1,1")
        assertThrows<IllegalArgumentException> { validateWinningNumbersDistinctness(numbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0,1,2,3,4,5", "1,2,3,4,5,999"])
    fun `당첨 번호 중 1 이상 45 이하가 아닌 것이 있을 경우 예외가 발생한다`(input: String) {
        val numbers = parseWinningNumbers(input)
        assertThrows<IllegalArgumentException> { numbers.forEach { validateLottoNumberInRange(it) } }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다`() {
        val bonusNumber = parseNumericInput("6")
        val winningNumbers = parseWinningNumbers("1,2,3,4,5,6")
        assertThrows<IllegalArgumentException> { validateBonusNumberDistinctness(bonusNumber, winningNumbers) }
    }

    @Test
    fun `입력값 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("8000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "8개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 6]",
                    "[1, 2, 3, 4, 5, 7]",
                    "[1, 2, 3, 4, 5, 10]",
                    "[1, 2, 3, 4, 10, 11]",
                    "[1, 2, 3, 10, 11, 12]",
                    "[1, 2, 10, 11, 12, 13]",
                    "[1, 10, 11, 12, 13, 14]",
                    "[10, 11, 12, 13, 14, 15]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 1개",
                    "총 수익률은 25394437.5%입니다."
                )
            },
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 5, 10),
            listOf(1, 2, 3, 4, 10, 11),
            listOf(1, 2, 3, 10, 11, 12),
            listOf(1, 2, 10, 11, 12, 13),
            listOf(1, 10, 11, 12, 13, 14),
            listOf(10, 11, 12, 13, 14, 15)
        )
    }

    override fun runMain() {
        main()
    }
}
