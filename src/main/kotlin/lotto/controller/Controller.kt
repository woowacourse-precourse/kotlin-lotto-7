package lotto.controller

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
     fun getBonusBall() = bonusBall
    fun getPrizeMoney() = prizeMoney
    fun getIndex() = index
}

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGame = LottoGame()

    private var lottoTickets: List<List<Int>> = listOf()
    private var winningGames = List(5) {0}

    fun start() {
        val count = buyLotto()
        lottoTickets = lottoGame.generateLottoTickets(count)

        outputView.showPrompt(REQUEST_WINNING_NUMBER_MESSAGE)
        val winningInput = inputView.readLine()
        val winningNumber = winningInput.split(SEPARATOR)
        val winningNumbers: MutableList<Int> = mutableListOf()
        winningNumber.forEach { winningNumbers.add(it.toInt()) }

        outputView.showPrompt(REQUEST_BONUS_NUMBER_MESSAGE)
        val bonusNumber = inputView.readLine()

        lottoGame.set(winningNumbers)
        winningGames = lottoGame.getWinnings(bonusNumber)

        outputView.showPrompt(TOTAL_WINNING_MESSAGE)
        outputView.showPrompt(LINE_SYMBOL)
        showResult(Ranking.FIFTH)
        showResult(Ranking.FOURTH)
        showResult(Ranking.THIRD)
        showResult(Ranking.SECOND)
        showResult(Ranking.FIRST)

        val totalPrize = Ranking.FIFTH.getPrizeMoney() * winningGames[Ranking.FIFTH.getIndex()] + Ranking.FOURTH.getPrizeMoney() * winningGames[Ranking.FOURTH.getIndex()] + Ranking.THIRD.getPrizeMoney() * winningGames[Ranking.THIRD.getIndex()] + Ranking.SECOND.getPrizeMoney() * winningGames[Ranking.SECOND.getIndex()] + Ranking.FIRST.getPrizeMoney() * winningGames[Ranking.FIRST.getIndex()]
        //TODO: 현재 정수로만 나옴. 소숫점 두 번째에서 반올림하여 소숫점 첫째자리까지 출력하거나, 정수면 정수로 출력하도록 변경 요망.
        val ratePrize = totalPrize/(count * 10)
        outputView.showPrompt(PREFIX_RETURN_MESSAGE + ratePrize + SUFFIX_RETURN_MESSAGE)
    }

    private fun buyLotto(): Int {
        var priceInput: String
        var price : Int?
        do {
            outputView.showPrompt(REQUEST_PURCHASE_MESSAGE)
            priceInput = inputView.readLine()
            price = lottoGame.validatePrice(priceInput)
            if (price !is Int) {
                outputView.showPrompt(ERROR_INPUT_PRICE_MESSAGE)
            }
        } while (price !is Int)
        val count = lottoGame.buy(price)
        outputView.showPrompt("$count" + CONFIRM_COUNT_MESSAGE)
        return count
    }

    private fun formatMoney(money: Int): String {
        var formated = ""
        val moneyString = money.toString()
        val num = moneyString.length % 3 - 1
        for (index in moneyString.indices) {
            formated += moneyString[index]
            if (index%3 == num && index != moneyString.length - 1) {
                formated += SEPARATOR
            }
        }
        return formated
    }

    fun showResult(ranking: Ranking){
        var result = "${ranking.getWinningBall()}" + FIRST_MESSAGE
        if (ranking.getWinningBall() == 5 && ranking.getBonusBall()) {
            result += BONUS_BALL_MESSAGE
        }
        result += SECOND_MESSAGE + formatMoney(ranking.getPrizeMoney()) + THIRD_MESSAGE + winningGames[ranking.getIndex()] + LAST_MESSAGE
        outputView.showPrompt(result)
    }

    companion object {
        const val REQUEST_PURCHASE_MESSAGE = "구입금액을 입력해 주세요."
        const val CONFIRM_COUNT_MESSAGE = "개를 구매했습니다."
        const val REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
        const val REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
        const val TOTAL_WINNING_MESSAGE = "\n당첨 통계"
        const val LINE_SYMBOL = "---"
        const val FIRST_MESSAGE = "개 일치"
        const val SECOND_MESSAGE = " ("
        const val THIRD_MESSAGE = "원) - "
        const val LAST_MESSAGE = "개"
        const val BONUS_BALL_MESSAGE = ", 보너스 볼 일치"
        const val PREFIX_RETURN_MESSAGE = "\n총 수익률은 "
        const val SUFFIX_RETURN_MESSAGE = "%입니다."

        const val ERROR_INPUT_PRICE_MESSAGE= "[ERROR] 구매 가격은 정수여야 합니다."

        const val SEPARATOR = ","
    }

}