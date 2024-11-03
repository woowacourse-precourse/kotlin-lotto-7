package lotto.service

import lotto.controller.dto.PurchasedLottoNumbersDto
import lotto.controller.dto.PurchasedLottoTicketsDto
import lotto.controller.dto.WinningProfitRateDto
import lotto.controller.dto.WinningStatisticsDto
import lotto.domain.Lotto
import lotto.domain.enum.Prize

class LottoGameService {
    fun issueLottoTickets(purchaseAmount: Int): PurchasedLottoTicketsDto {
        val count: Int = purchaseAmount / 1000
        val lottoTickets: List<Lotto> = List(count) { Lotto.generate() }
        return PurchasedLottoTicketsDto(lottoTickets)
    }

    fun calculateResults(
        purchasedLottoTickets: PurchasedLottoTicketsDto,
        purchasedLottoNumbers: PurchasedLottoNumbersDto
    ): WinningStatisticsDto {
        val results = mutableMapOf<Prize, Int>().apply {
            Prize.entries.forEach { this[it] = 0 }
        }

        purchasedLottoTickets.lottoTickets.forEach { lottoTicket ->
            val matchCount: Int = lottoTicket.getLottNumbers().count { it in purchasedLottoNumbers.winningNumbers }
            val bonusMatch: Boolean = purchasedLottoNumbers.bonusNumber in lottoTicket.getLottNumbers()

            val prize: Prize = Prize.getPrize(matchCount, bonusMatch)
            results[prize] = results[prize]!! + 1
        }

        return WinningStatisticsDto(results)
    }

    fun calculateProfitRate(results: WinningStatisticsDto, purchaseAmount: Int): WinningProfitRateDto {
        val winningStatistics: Map<Prize, Int> = results.winningStatisticsDto
        val totalPrize: Int = winningStatistics.entries.sumOf { (prize, count) -> prize.money * count }

        val profit: Double = (totalPrize.toDouble() / purchaseAmount) * 100.0
        return WinningProfitRateDto(Math.round(profit * 10.0) / 10.0)
    }
}
