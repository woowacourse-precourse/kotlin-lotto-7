package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.util.ConstantsUtil.DELIMITER_COMMA
import lotto.util.ConstantsUtil.MESSAGE_BONUS_NUMBER
import lotto.util.ConstantsUtil.MESSAGE_CALCULATED_TICKETS
import lotto.util.ConstantsUtil.MESSAGE_DEFAULT_WINNING
import lotto.util.ConstantsUtil.MESSAGE_RETURN_RATE
import lotto.util.ConstantsUtil.MESSAGE_SECOND_WINNING
import lotto.util.ConstantsUtil.MESSAGE_SHOW_CALCULATED_TICKETS
import lotto.util.ConstantsUtil.MESSAGE_TICKETS_COUNT
import lotto.util.ConstantsUtil.MESSAGE_TICKETS_PRICE
import lotto.util.ConstantsUtil.MESSAGE_WINNING_NUMBERS
import lotto.util.ValidatorUtil.validateBonusNumber
import lotto.util.ValidatorUtil.validateTicketsPriceNumber
import lotto.util.ValidatorUtil.validateWinningNumbers
import java.text.DecimalFormat
import java.text.NumberFormat

class LottoViewImpl: LottoView {
    override fun showTickets(tickets: List<Lotto>) {
        println(formatShowTickets(tickets.size))
        tickets.forEach { println(it.getNumbers()) }
    }

    override fun showCalculatedTickets(calculatedTickets: Map<LottoRank, Int>) {
        println(MESSAGE_SHOW_CALCULATED_TICKETS)
        LottoRank.entries.reversed().forEach { rank ->
            if(rank != LottoRank.NONE){
                val rankMessage = getRankMessage(rank)
                println(formatCalculatedTickets(rankMessage, rank.reward, calculatedTickets[rank] ?: 0))
            }
        }
    }

    override fun getTicketsPrice(): Int {
        println(MESSAGE_TICKETS_PRICE)
        val input = Console.readLine()
        validateTicketsPriceNumber(input)
        return input.toInt()
    }

    override fun getWinningNumbers(): List<Int> {
        println(MESSAGE_WINNING_NUMBERS)
        val inputWinningNumbers = Console.readLine().split(DELIMITER_COMMA).map { it.toIntOrNull() }
        validateWinningNumbers(inputWinningNumbers)
        return inputWinningNumbers.filterNotNull()
    }

    override fun getBonusNumber(): Int {
        println(MESSAGE_BONUS_NUMBER)
        val input = Console.readLine()
        validateBonusNumber(input)
        return input.toInt()
    }

    override fun showReturnRate(returnRate: Double) {
        println(formatShowReturnRate(returnRate))
    }

    private fun formatShowTickets(ticketsSize: Int): String {
        return MESSAGE_TICKETS_COUNT.format(ticketsSize)
    }

    private fun getRankMessage(rank: LottoRank): String {
        return when (rank) {
            LottoRank.SECOND -> MESSAGE_SECOND_WINNING
            else -> MESSAGE_DEFAULT_WINNING.format(rank.matchCount)
        }
    }


    private fun formatCalculatedTickets(messageRank: String, reward: Int, ticketCount: Int): String {
        val formatReward = NumberFormat.getNumberInstance().format(reward)
        return MESSAGE_CALCULATED_TICKETS.format(messageRank, formatReward, ticketCount)
    }

    private fun formatShowReturnRate(returnRate: Double): String {
        val decimalFormat = DecimalFormat("0.##")
        val formattedRate = decimalFormat.format(returnRate)
        return MESSAGE_RETURN_RATE.format(formattedRate)
    }
}