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

    @Test
    fun `발행된 각 로또 티켓 번호는 중복 없는 6자리여야 한다`() {
        val lottoTicketsField = LottoManager::class.java.getDeclaredField("lottoTickets")
        lottoTicketsField.isAccessible = true
        val lottoTickets = lottoTicketsField.get(lottoManager) as List<Lotto>

        lottoTickets.forEach { ticket ->
            assertThat(ticket.getLottoNumbers().toSet().size).isEqualTo(6)
        }
    }

    @Test
    fun `당첨 번호와 비교하여 당첨 결과가 올바른지 확인`() {

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6개 일치 -> 1등
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 5개 + 보너스 일치 -> 2등
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5개 일치 -> 3등
            Lotto(listOf(1, 2, 3, 4, 10, 11)), // 4개 일치 -> 4등
            Lotto(listOf(1, 2, 3, 7, 8, 9)) // 3개 일치 -> 5등
        )

        val lottoTicketsField = LottoManager::class.java.getDeclaredField("lottoTickets")
        lottoTicketsField.isAccessible = true
        lottoTicketsField.set(lottoManager, tickets)

        lottoManager.compareResults(winningNumbers, bonusNumber)
    }
}