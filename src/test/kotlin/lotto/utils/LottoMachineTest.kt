package lotto.utils

import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `6개의 번호를 가진 로또를 생성한다`() {
        val lotto = LottoMachine.generate()
        assert(lotto.getNumbers().size == 6)
    }
}