package view

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputViewTest : NsTest() {
    @Test
    fun `구입한 로또의 개수와 번호를 출력한다`() {
        val lottos = ArrayList<List<Int>>()
        for (i in 0..4) {
            lottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
        OutputView().printLottoNumbers(5, lottos)
        assertThat(output()).contains(OutputView.AMOUNT_NOTICE.format(5))
    }

    override fun runMain() {
        OutputView()
    }
}