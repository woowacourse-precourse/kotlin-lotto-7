package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMachineTest {
    private val lottoMachine = LottoMachine()

    @Test
    fun `로또 머신이 요청한 개수만큼 로또를 반환한다(개수 판볆)`() {
        val lottoCount = 5

        val lottos: List<Lotto> = lottoMachine.createLottos(lottoCount)

        val expected: List<Lotto> = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(2, 3, 4, 5, 6, 7)),
            Lotto(listOf(3, 4, 5, 6, 7, 8)),
            Lotto(listOf(10, 11, 12, 13, 14, 15)),
            Lotto(listOf(11, 12, 13, 14, 15, 16)),
        )
        assertEquals(expected.size, lottos.size)
    }
}