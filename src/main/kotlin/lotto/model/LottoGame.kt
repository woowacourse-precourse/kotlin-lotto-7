package lotto.model

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.controller.Controller.Companion.SEPARATOR

class LottoGame {
    val lottoOrder = LottoOrder()
    val lottoWinning = LottoWinning()

    val rankings: MutableList<Rank> = mutableListOf(
        Rank(Ranking.FIFTH),
        Rank(Ranking.FOURTH),
        Rank(Ranking.THIRD),
        Rank(Ranking.SECOND),
        Rank(Ranking.FIRST),
    )

    fun validateMoney(money: String): String? {
        require(money.trim().toIntOrNull() != null) { return ERROR_INPUT_MONEY_NUMBER_MESSAGE }
        require(money.trim().toInt() % LOTTO_TICKET_PRICE == 0) { return ERROR_REQUIRE_MINIMUM_THOUSAND_MESSAGE }
        require(money.trim().toInt() < LOTTO_MAXIMUM_MONEY) { return ERROR_REQUIRE_MAXIMUM_HUNDRED_THOUSAND_MESSAGE }
        lottoOrder.money = money.trim().toInt()
        return null
    }

    fun validateNumbers(winningInput: String): String? {
        val winningNumber = winningInput.split(SEPARATOR)
        require(winningNumber.all { it.trim().toIntOrNull() is Int }) { return ERROR_REQUIRE_LOTTO_NUMBER_MESSAGE }
        require(winningNumber.all { it.trim().toInt() in MIN_BALL_NUMBER..MAX_BALL_NUMBER }) { return ERROR_REQUIRE_LOTTO_NUMBER_RANGE_MESSAGE }
        require(winningNumber.size == WINNING_BALL_COUNT) { return ERROR_REQUIRE_LOTTO_SIZE_MESSAGE }
        require(winningNumber.size == winningNumber.distinct().size) { return ERROR_REQUIRE_UNIQUE_NUMBER_MESSAGE }
        lottoWinning.numbers = winningNumber.map { it.trim().toInt() }
        return null
    }

    fun validateBonus(bonusInput: String): String? {
        require(bonusInput.trim().toIntOrNull() != null) { return ERROR_REQUIRE_BONUS_NUMBER_MESSAGE }
        val bonus = bonusInput.trim().toInt()
        require(bonus in MIN_BALL_NUMBER..MAX_BALL_NUMBER) { return ERROR_REQUIRE_BONUS_NUMBER_RANGE_MESSAGE }
        require(!lottoWinning.numbers.contains(bonus)) { return ERROR_MUST_UNIQUE_WITH_LOTTO_MESSAGE }
        lottoWinning.bonus = bonusInput.trim().toInt()
        return null
    }

    fun buy(price: Int) {
        lottoOrder.money = price
        lottoOrder.ticketAmount = price / LOTTO_TICKET_PRICE
    }

    fun generateLottoTickets(count: Int) {
        repeat(count) {
            val numbers =
                pickUniqueNumbersInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER, WINNING_BALL_COUNT)
            val lottoTicket = Lotto(numbers).sort()
            println(lottoTicket)
            lottoOrder.totalTickets.add(lottoTicket)
        }
    }

    fun checkScore(lotto: List<Int>): Int {
        var winningCount = 0
        lotto.forEach {
            if (lottoWinning.numbers.contains(it)) {
                winningCount++
            }
        }
        return winningCount
    }

    private fun checkBonus(lotto: List<Int>): Boolean {
        return lotto.contains(lottoWinning.bonus)
    }

    fun play() {
        for (lotto in lottoOrder.totalTickets) {
            val win = checkScore(lotto)
            val bonus = checkBonus(lotto)
            updateWins(win, bonus)
        }
    }

    private fun updateWins(win: Int, bonus: Boolean) {
        for (index in 0 until rankings.size) {
            if (win == rankings[index].ranking.getWinningBall() && bonus == rankings[index].ranking.getBonusBall()) {
                rankings[index].updateWins()
            }
        }
    }

    fun getResult(ranking: Rank): String {
        var result = "${ranking.ranking.getWinningBall()}" + FIRST_MESSAGE
        if (ranking.ranking.getWinningBall() == SECOND_WINNING_BALL_COUNT && ranking.ranking.getBonusBall()) {
            result += BONUS_BALL_MESSAGE
        }
        result += SECOND_MESSAGE + formatMoney(ranking.ranking.getPrizeMoney()) + THIRD_MESSAGE + ranking.wins + LAST_MESSAGE
        return result
    }

    private fun formatMoney(money: Int): String {
        var formated = ""
        val moneyString = money.toString()
        val num = moneyString.length % 3 - 1
        for (index in moneyString.indices) {
            formated += moneyString[index]
            if (index % 3 == num && index != moneyString.length - 1) {
                formated += SEPARATOR
            }
        }
        return formated
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1_000
        const val LOTTO_MAXIMUM_MONEY = 100_000

        const val WINNING_BALL_COUNT = 6
        const val MIN_BALL_NUMBER = 1
        const val MAX_BALL_NUMBER = 45

        const val ERROR_INPUT_MONEY_NUMBER_MESSAGE = "[ERROR] 구매 가격은 숫자여야 합니다."
        const val ERROR_REQUIRE_MINIMUM_THOUSAND_MESSAGE = "[ERROR] 구매 금액은 1,000원 단위로 구매할 수 있습니다."
        const val ERROR_REQUIRE_MAXIMUM_HUNDRED_THOUSAND_MESSAGE = "[ERROR] 1인 최대 구매 금액은 100,000원입니다."

        const val ERROR_REQUIRE_LOTTO_NUMBER_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        const val ERROR_REQUIRE_LOTTO_NUMBER_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다."
        const val ERROR_REQUIRE_LOTTO_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다."
        const val ERROR_REQUIRE_UNIQUE_NUMBER_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다."

        const val ERROR_REQUIRE_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 하나의 숫자여야 합니다."
        const val ERROR_REQUIRE_BONUS_NUMBER_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
        const val ERROR_MUST_UNIQUE_WITH_LOTTO_MESSAGE = "[ERROR] 보너스 번호와 로또 번호는 같을 수 없습니다."

        const val FIRST_MESSAGE = "개 일치"
        const val SECOND_MESSAGE = " ("
        const val THIRD_MESSAGE = "원) - "
        const val LAST_MESSAGE = "개"
        const val BONUS_BALL_MESSAGE = ", 보너스 볼 일치"
    }
}