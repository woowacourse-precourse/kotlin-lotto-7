package lotto.model

import lotto.dto.LottoTicketDTO

class LottoMachine(
    private val money: Money,
    numberGenerator: NumberGenerator = LottoNumberGenerator()
) {
    val lottoTickets: List<Lotto> = generateLottoTickets(numberGenerator)

    fun generateLottoTicketDTOList(): List<LottoTicketDTO> {
        return lottoTickets.map { lotto ->
            LottoTicketDTO(lotto.map { it.number })
        }
    }

    private fun generateLottoTickets(numberGenerator: NumberGenerator): List<Lotto> {
        return List(money.getLottoCount()) {
            Lotto.createRandomLotto(numberGenerator)
        }
    }
}
