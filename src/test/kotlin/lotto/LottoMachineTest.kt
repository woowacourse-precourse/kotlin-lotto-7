package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest: NsTest() {

    @Test
    fun `기능테스트-수익률 계산하기`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run()
                assertThat(output()).contains(
                    "수익률 : 500.0"
                )
            },
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
        )
    }

    private fun 수익률계산테스트실행() {
        val lottoMachine = LottoMachine(5000)
        println(
            "수익률 : " + lottoMachine.getEarningsRate(
                winningNumber = listOf(1,2,3,8,9,15),
                bonusNumber = 10,
            )
        )
    }

    override fun runMain() {
        수익률계산테스트실행()
    }
}