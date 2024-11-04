package lotto.core

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.calculator.LottoProfitCalculator
import lotto.calculator.LottoStatsCalculator
import lotto.data.BonusNumber
import lotto.data.Lotto
import lotto.data.PurchaseAmount
import lotto.enums.Rank
import lotto.constants.Format.DELIMITER_COMMA_WITH_SPACE
import lotto.constants.Format.DIVIDER
import lotto.constants.Format.LOTTO_STATS_HEADER
import lotto.constants.Message.MESSAGE_FORMATTED_PROFIT_RATE
import lotto.constants.Message.MESSAGE_INVALID_INPUT
import lotto.constants.Message.MESSAGE_LOTTO_TICKETS_PURCHASED
import lotto.constants.Message.MESSAGE_LOTTO_TICKET_FORMAT
import lotto.constants.Message.MESSAGE_PROMPT_BONUS_NUMBER
import lotto.constants.Message.MESSAGE_PROMPT_PURCHASE_AMOUNT
import lotto.constants.Message.MESSAGE_PROMPT_WINNING_NUMBER


const val TICKET_PRICE = 1000

class LottoMachine {
    private var purchaseAmount: Int = 0
    private val lottoTickets = mutableListOf<List<Int>>()
    private var winningNumber = listOf<Int>()
    private var bonusNumber = 0
    private var lottoStats = listOf<Rank>()


    fun run() {
        requestPurchaseAmount()
        printPurchasedLottoTickets()

        requestWinningNumber()
        requestBonusNumber()

        printLottoStats()
        printLottoProfit()
    }

    private fun requestPurchaseAmount() {
        while (true) {
            try {
                println(MESSAGE_PROMPT_PURCHASE_AMOUNT)

                purchaseAmount = PurchaseAmount(Console.readLine(), TICKET_PRICE).getAmount()
                break
            } catch (e: IllegalArgumentException) {
                println(MESSAGE_INVALID_INPUT.format(e.message))
            }
        }
        println()
    }

    private fun printPurchasedLottoTickets() {
        val purchasedLottoCount = purchaseAmount / TICKET_PRICE

        println(MESSAGE_LOTTO_TICKETS_PURCHASED.format(purchasedLottoCount))

        repeat(purchasedLottoCount) {
            val userLottoTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            lottoTickets.add(userLottoTicket)

            println(MESSAGE_LOTTO_TICKET_FORMAT.format(userLottoTicket.joinToString(DELIMITER_COMMA_WITH_SPACE)))
        }
        println()
    }

    private fun requestWinningNumber() {
        while (true) {
            try {
                println(MESSAGE_PROMPT_WINNING_NUMBER)

                winningNumber = Lotto(Console.readLine()).getWinningNumber()
                break
            } catch (e: IllegalArgumentException) {
                println(MESSAGE_INVALID_INPUT.format(e.message))
            } catch (e: NumberFormatException) {
                println("숫자를 입력해 주세요.")
            }
        }
        println()
    }

    private fun requestBonusNumber() {
        while (true) {
            try {
                println(MESSAGE_PROMPT_BONUS_NUMBER)

                bonusNumber = BonusNumber(Console.readLine(), winningNumber).getNumber()
                break
            } catch (e: IllegalArgumentException) {
                println(MESSAGE_INVALID_INPUT.format(e.message))
            } catch (e: NumberFormatException) {
                println("숫자를 입력해 주세요.")
            }
        }
        println()
    }

    private fun printLottoStats() {
        lottoStats = LottoStatsCalculator(lottoTickets, winningNumber, bonusNumber).getLottoStats()

        println(LOTTO_STATS_HEADER)
        println(DIVIDER)

        Rank.entries.reversed().forEach { rank ->   // 5등에서 1등 순서로 출력
            if (rank == Rank.SECOND) {
                println("${rank.matchCount}개 일치, 보너스 볼 일치 (${rank.prize}원) - ${lottoStats.count { it == rank }}개")
                return@forEach
            }
            println("${rank.matchCount}개 일치 (${rank.prize}원) - ${lottoStats.count { it == rank }}개")
        }
    }

    private fun printLottoProfit() =
        println(
            MESSAGE_FORMATTED_PROFIT_RATE.format(
                LottoProfitCalculator(
                    lottoStats,
                    purchaseAmount
                ).getLottoProfit()
            )
        )
}