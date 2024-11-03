package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    private val lottoMachine = LottoMachine()

    @Test
    fun `로또 티켓을 지정된 수만큼 생성한다`() {
        val lottoTicketCount = 5
        val tickets = lottoMachine.generateLottoTickets(lottoTicketCount)

        assertThat(tickets).hasSize(lottoTicketCount)
    }

    @Test
    fun `생성된 로또 티켓의 각 번호는 1부터 45 사이의 고유 번호 6개로 구성된다`() {
        val tickets = lottoMachine.generateLottoTickets(10)

        tickets.forEach { ticket ->
            val numbers = ticket.toString()
                .removeSurrounding("[", "]")
                .split(", ")
                .map { it.toInt() }

            assertThat(numbers).hasSize(6)
            assertThat(numbers).allMatch { it in 1..45 }
            assertThat(numbers).doesNotHaveDuplicates()
        }
    }

    @Test
    fun `티켓 번호는 오름차순으로 정렬되어야 한다`() {
        val tickets = lottoMachine.generateLottoTickets(5)

        tickets.forEach { ticket ->
            val numbers = ticket.toString()
                .removeSurrounding("[", "]")
                .split(", ")
                .map { it.toInt() }

            val sortedNumbers = numbers.sorted()
            assertThat(numbers).isEqualTo(sortedNumbers)
        }
    }
}