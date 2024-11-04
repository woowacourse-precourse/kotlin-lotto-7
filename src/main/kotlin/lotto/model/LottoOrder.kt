package lotto.model

data class LottoOrder(
    var money: Int = 0,
    var ticketAmount: Int = 0,
    var totalTickets: MutableList<List<Int>> = mutableListOf(listOf())
)