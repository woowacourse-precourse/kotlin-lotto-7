package lotto.manager

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto

class LottoBuyManager {

    var buyMoney: Int = DEFAULT_MONEY
    val userLottos = mutableListOf<Lotto>()

    fun requestMoney() {
        println(REQUEST_MONEY_MESSAGE)
        val moneyInput = Console.readLine()
        try {
            validateMoneyInput(moneyInput)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
            requestMoney()
        }
    }

    private fun validateMoneyInput(moneyInput: String) {
        if (!moneyInput.matches(Regex(REGEX_NUMBER_PATTERN))) {
            throw IllegalArgumentException("$ERROR_TITLE $ERROR_NOT_NUMBER_MESSAGE")
        }

        buyMoney = moneyInput.toInt()

        if (buyMoney < LOTTO_PRICE) {
            throw IllegalArgumentException("$ERROR_TITLE $ERROR_MINIMUM_AMOUNT_MESSAGE")
        }

        if (buyMoney % LOTTO_PRICE != MONEY_DIVISIBLE_STANDARD) {
            throw IllegalArgumentException("$ERROR_TITLE $ERROR_UNIT_AMOUNT_MESSAGE")
        }
    }

    fun buyLottos() {
        val lottoCount = buyMoney / LOTTO_PRICE
        println("${lottoCount}$BUY_LOTTOS_MESSAGE")
        repeat(lottoCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_COUNT).sorted()
            println(numbers)
            userLottos.add(Lotto(numbers))
        }
        println()
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val LOTTO_RANGE_START = 1
        private const val LOTTO_RANGE_END = 45
        private const val LOTTO_COUNT = 6
        private const val DEFAULT_MONEY = 0
        private const val MONEY_DIVISIBLE_STANDARD = 0
        private const val REQUEST_MONEY_MESSAGE = "구입금액을 입력해 주세요."
        private const val BUY_LOTTOS_MESSAGE = "개를 구매했습니다."
        private const val REGEX_NUMBER_PATTERN = "^[0-9]+\$"
        private const val ERROR_TITLE = "[ERROR]"
        private const val ERROR_NOT_NUMBER_MESSAGE = "금액은 부호가 없는 숫자만 입력 가능합니다."
        private const val ERROR_MINIMUM_AMOUNT_MESSAGE = "로또 구입금액은 1000원 이상이어야 합니다."
        private const val ERROR_UNIT_AMOUNT_MESSAGE = "로또 구입금액은 1000원 단위여야 합니다."
    }
}