package lotto.controller

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.model.Lotto
import lotto.model.LottoGame
import lotto.view.InputView
import lotto.view.OutputView

enum class Ranking(
    private val winningBall: Int, private val bonusBall: Boolean, private val prizeMoney: Int, private val index: Int
) {
    FIRST(6, false, 2000000000, 0),
    SECOND(5, true, 30000000, 1),
    THIRD(5, false, 1500000, 2),
    FOURTH(4, false, 50000,3),
    FIFTH(3, false, 5000,4);

    fun getWinningBall() = winningBall
    // fun getBonusBall() = bonusBall
    fun getPrizeMoney() = prizeMoney
    fun getIndex() = index
}

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGame = LottoGame()

    private val lottoTickets: MutableList<List<Int>> = mutableListOf()
    private val winningGames = MutableList(5) {0}

    fun start() {
        var price: String
        do {
            outputView.showPrompt(REQUEST_PURCHASE_MESSAGE)
            price = inputView.readLine()
            val a = lottoGame.validatePrice(price)
            if (a is String) {
                outputView.showPrompt(a)
            }
        } while (a is String)
        val count = lottoGame.buy(price)
        outputView.showPrompt("$count" + CONFIRM_COUNT_MESSAGE)

        repeat(count) {
            val numbers = pickUniqueNumbersInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER, WINNING_BALL_COUNT)
            val lottoTicket = Lotto(numbers).sort()
            println(lottoTicket)
            lottoTickets.add(lottoTicket)
        }

        outputView.showPrompt(REQUEST_WINNING_NUMBER_MESSAGE)
        val winningNumber = inputView.readLine()
        val splitedWinningNumber = winningNumber.split(SEPARATOR)
        val winningNumbers: MutableList<Int> = mutableListOf()
        splitedWinningNumber.forEach { winningNumbers.add(it.toInt()) }

        outputView.showPrompt(REQUEST_BONUS_NUMBER_MESSAGE)
        val bonusNumber = inputView.readLine()

        for (lotto in lottoTickets) {
            lottoGame.set(lotto)
            val win = lottoGame.check(winningNumbers)
            val bonus = lottoGame.isBonus(bonusNumber.toInt())
            when {
                win == 6 -> winningGames[Ranking.FIRST.getIndex()] += 1
                win == 5 && bonus -> winningGames[Ranking.SECOND.getIndex()] += 1
                win == 5 && !bonus -> winningGames[Ranking.THIRD.getIndex()] += 1
                win == 4 -> winningGames[Ranking.FOURTH.getIndex()] += 1
                win == 3 -> winningGames[Ranking.FIFTH.getIndex()] += 1
            }
        }

        outputView.showPrompt(TOTAL_WINNING_MESSAGE)
        outputView.showPrompt(LINE_SYMBOL)
        outputView.showPrompt("${Ranking.FIFTH.getWinningBall()}" + FIRST_MESSAGE + "${Ranking.FIFTH.getPrizeMoney()}" + SECOND_MESSAGE + "${winningGames[Ranking.FIFTH.getIndex()]}" + LAST_MESSAGE)
        outputView.showPrompt("${Ranking.FOURTH.getWinningBall()}" + FIRST_MESSAGE + "${Ranking.FOURTH.getPrizeMoney()}" + SECOND_MESSAGE + "${winningGames[Ranking.FOURTH.getIndex()]}" + LAST_MESSAGE)
        outputView.showPrompt("${Ranking.THIRD.getWinningBall()}" + FIRST_MESSAGE + "${Ranking.THIRD.getPrizeMoney()}" + SECOND_MESSAGE + "${winningGames[Ranking.THIRD.getIndex()]}" + LAST_MESSAGE)
        outputView.showPrompt("${Ranking.SECOND.getWinningBall()}" + FIRST_MESSAGE + BONUS_BALL_MESSAGE + "${Ranking.SECOND.getPrizeMoney()}" + SECOND_MESSAGE + "${winningGames[Ranking.SECOND.getIndex()]}" + LAST_MESSAGE)
        outputView.showPrompt("${Ranking.FIRST.getWinningBall()}" + FIRST_MESSAGE + "${Ranking.FIRST.getPrizeMoney()}" + SECOND_MESSAGE + "${winningGames[Ranking.FIRST.getIndex()]}" + LAST_MESSAGE)

        val returnPrice = Ranking.FIFTH.getPrizeMoney() * winningGames[Ranking.FIFTH.getIndex()] + Ranking.FOURTH.getPrizeMoney() * winningGames[Ranking.FOURTH.getIndex()] + Ranking.THIRD.getPrizeMoney() * winningGames[Ranking.THIRD.getIndex()] + Ranking.SECOND.getPrizeMoney() * winningGames[Ranking.SECOND.getIndex()] + Ranking.FIRST.getPrizeMoney() * winningGames[Ranking.FIRST.getIndex()]
        val rateOfReturn = (returnPrice/price.toInt()) * 100
        outputView.showPrompt(PREFIX_RETURN_MESSAGE + "$rateOfReturn" + SUFFIX_RETURN_MESSAGE)
    }


    companion object {
        const val REQUEST_PURCHASE_MESSAGE = "구입금액을 입력해 주세요."
        const val CONFIRM_COUNT_MESSAGE = "개를 구매했습니다."
        const val REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
        const val REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
        const val TOTAL_WINNING_MESSAGE = "\n당첨 통계"
        const val LINE_SYMBOL = "---"
        const val FIRST_MESSAGE = "개 일치 ("
        const val SECOND_MESSAGE = "원) - "
        const val LAST_MESSAGE = "개"
        const val BONUS_BALL_MESSAGE = ", 보너스 볼 일치"
        const val PREFIX_RETURN_MESSAGE = "\n총 수익률은 "
        const val SUFFIX_RETURN_MESSAGE = "%입니다."

        const val SEPARATOR = ","

        const val MAX_BALL_NUMBER = 45
        const val MIN_BALL_NUMBER = 1
        const val WINNING_BALL_COUNT = 6
    }
}