package lotto.model

data class LottoOrder(
    var totalPrice: Int = 0,
    var totalTicket: Int = 0,
    var totalTickets: MutableList<List<Int>> = mutableListOf(listOf())
)