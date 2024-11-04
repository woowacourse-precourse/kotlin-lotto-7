package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoManagerTest {

    private lateinit var lottoManager: LottoManager

    @BeforeEach
    fun `8개의 로또 티켓 발행 매니저`() {
        lottoManager = LottoManager(8)
    }

    @Test
    fun `로또 티켓 수량이 맞게 생성되는지 확인`() {
        val lottoTicketsField = LottoManager::class.java.getDeclaredField("lottoTickets")
        lottoTicketsField.isAccessible = true
        val lottoTickets = lottoTicketsField.get(lottoManager) as List<Lotto>

        assertThat(lottoTickets.size).isEqualTo(8)
    }
}