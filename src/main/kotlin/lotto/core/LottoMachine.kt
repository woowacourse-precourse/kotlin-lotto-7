package lotto.core

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.data.Lotto
import lotto.data.PurchaseAmount

const val TICKET_PRICE = 1000

class LottoMachine {
    private var purchaseAmount: Int = 0
    private val lottoTickets = mutableListOf<List<Int>>()
    private var winningNumber = listOf<Int>()


    fun run() {
        requestPurchaseAmount()
        printPurchasedLottoTickets()

        requestWinningNumber()
    }

    private fun requestPurchaseAmount() {
        while (true) {
            try {
                println("구입금액을 입력해 주세요.")

                purchaseAmount = PurchaseAmount(Console.readLine(), TICKET_PRICE).getAmount()
                break
            } catch (e: IllegalArgumentException) {
                println("잘못된 입력입니다. 다시 입력해 주세요. ${e.message}")
            }
        }
    }

    private fun printPurchasedLottoTickets() {
        val purchasedLottoCount = purchaseAmount / TICKET_PRICE

        println("${purchasedLottoCount}개를 구매했습니다.")

        repeat(purchasedLottoCount) {
            val userLottoTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            lottoTickets.add(userLottoTicket)

            println("[${userLottoTicket.joinToString(", ")}]")
        }
        println()
    }

    private fun requestWinningNumber() {
        while (true) {
            try {
                println("당첨 번호를 입력해 주세요.")

                winningNumber = Lotto(Console.readLine()).getWinningNumber()
                break
            } catch (e: IllegalArgumentException) {
                println("잘못된 입력입니다. 다시 입력해 주세요. ${e.message}")
            } catch (e: NumberFormatException) {
                println("숫자를 입력해 주세요.")
            }
        }
    }

}