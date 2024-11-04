package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.util.ConstantsUtil.DELIMITER_COMMA
import lotto.util.ConstantsUtil.MESSAGE_BONUS_NUMBER
import lotto.util.ConstantsUtil.MESSAGE_CALCULATED_TICKETS
import lotto.util.ConstantsUtil.MESSAGE_SHOW_CALCULATED_TICKETS
import lotto.util.ConstantsUtil.MESSAGE_TICKETS_COUNT
import lotto.util.ConstantsUtil.MESSAGE_TICKETS_PRICE
import lotto.util.ConstantsUtil.MESSAGE_WINNING_NUMBERS
import lotto.util.ValidatorUtil.validateBonusNumber
import lotto.util.ValidatorUtil.validateTicketsPrice
import lotto.util.ValidatorUtil.validateWinningNumbers
import java.text.NumberFormat

class LottoViewImpl: LottoView {
    override fun showTickets(tickets: List<Lotto>) {
        println(formatShowTickets(tickets.size))
        tickets.forEach { println(it.getNumbers()) }
    }

    override fun showCalculatedTickets(calculatedTickets: Map<LottoRank, Int>) {
        println(MESSAGE_SHOW_CALCULATED_TICKETS)
        LottoRank.entries.forEach { rank ->
            if(rank != LottoRank.NONE){
                println(formatCalculatedTickets(rank.matchCount, rank.reward, calculatedTickets[rank] ?: 0))
            }
        }
    }

    override fun getTicketsPrice(): Int {
        println(MESSAGE_TICKETS_PRICE)
        val input = Console.readLine()
        validateTicketsPrice(input)
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

    private fun formatShowTickets(ticketsSize: Int): String{
        return MESSAGE_TICKETS_COUNT.format(ticketsSize)
    }

    private fun formatCalculatedTickets(matchCount: Int, reward: Int, ticketCount: Int): String{
        val formatReward = NumberFormat.getNumberInstance().format(reward)
        return MESSAGE_CALCULATED_TICKETS.format(matchCount, formatReward, ticketCount)
    }
}