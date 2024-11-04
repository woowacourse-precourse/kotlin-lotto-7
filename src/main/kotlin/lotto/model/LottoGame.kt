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

    fun isValidMoney(money: String): String? {
        require(money.toIntOrNull() != null) { return ERROR_INPUT_MONEY_NUMBER_MESSAGE }
        require(money.toInt() % LOTTO_TICKET_PRICE == 0) { return ERROR_REQUIRE_MINIMUM_THOUSAND_MESSAGE }
        require(money.toInt() < LOTTO_MAXIMUM_MONEY) { return ERROR_REQUIRE_MAXIMUM_HUNDRED_THOUSAND_MESSAGE }
        lottoOrder.totalPrice = money.toInt()
        return null
    }

    fun isValidNumbers(winningInput: String): String? {
        val winningNumber = winningInput.split(SEPARATOR)
        require(winningNumber.all { it.toIntOrNull() is Int }) { return ERROR_REQUIRE_LOTTO_NUMBER_MESSAGE }
        require(winningNumber.all { it.toInt() in MIN_BALL_NUMBER..MAX_BALL_NUMBER }) { return ERROR_REQUIRE_LOTTO_NUMBER_RANGE_MESSAGE }
        require(winningNumber.size == WINNING_BALL_COUNT) { return ERROR_REQUIRE_LOTTO_SIZE_MESSAGE }
        require(winningNumber.size == winningNumber.distinct().size) { return ERROR_REQUIRE_UNIQUE_NUMBER_MESSAGE }
        lottoWinning.numbers = winningNumber.map { it.toInt() }
        return null
    }

    fun isValidBonus(bonusInput: String): String? {
        require(bonusInput.toIntOrNull() != null) { return ERROR_REQUIRE_BONUS_NUMBER_MESSAGE }
        val bonus = bonusInput.toInt()
        require(bonus in MIN_BALL_NUMBER..MAX_BALL_NUMBER) { return ERROR_REQUIRE_BONUS_NUMBER_RANGE_MESSAGE }
        require(!lottoWinning.numbers.contains(bonus)) { return ERROR_MUST_UNIQUE_WITH_LOTTO_MESSAGE }
        lottoWinning.bonus = bonusInput.toInt()
        return null
    }

    fun buy(price: Int) {
        lottoOrder.totalPrice = price
        lottoOrder.totalTicket = price / LOTTO_TICKET_PRICE
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

    fun setWinnings() {
        for (lotto in lottoOrder.totalTickets) {
            val win = checkScore(lotto)
            val bonus = checkBonus(lotto)
            when {
                win == rankings[0].ranking.getWinningBall() -> rankings[0].updateWins()
                win == rankings[1].ranking.getWinningBall() && bonus == rankings[1].ranking.getBonusBall() -> rankings[1].updateWins()
                win == rankings[2].ranking.getWinningBall() -> rankings[2].updateWins()
                win == rankings[3].ranking.getWinningBall() -> rankings[3].updateWins()
                win == rankings[4].ranking.getWinningBall() -> rankings[4].updateWins()
            }
        }
    }


    companion object {
        const val LOTTO_TICKET_PRICE = 1_000
        const val LOTTO_MAXIMUM_MONEY = 100_000

        const val WINNING_BALL_COUNT = 6
        const val MIN_BALL_NUMBER = 1
        const val MAX_BALL_NUMBER = 45

        const val ERROR_INPUT_MONEY_NUMBER_MESSAGE = "[ERROR] 구매 가격은 숫자여야 합니다."
        const val ERROR_REQUIRE_MINIMUM_THOUSAND_MESSAGE = "구매 금액은 1,000원 단위로 구매할 수 있습니다."
        const val ERROR_REQUIRE_MAXIMUM_HUNDRED_THOUSAND_MESSAGE = "1인 최대 구매 금액은 100,000원입니다."

        const val ERROR_REQUIRE_LOTTO_NUMBER_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        const val ERROR_REQUIRE_LOTTO_NUMBER_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다."
        const val ERROR_REQUIRE_LOTTO_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다."
        const val ERROR_REQUIRE_UNIQUE_NUMBER_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다."

        const val ERROR_REQUIRE_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다."
        const val ERROR_REQUIRE_BONUS_NUMBER_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
        const val ERROR_MUST_UNIQUE_WITH_LOTTO_MESSAGE = "보너스 번호와 로또 번호는 같을 수 없습니다."
    }
}