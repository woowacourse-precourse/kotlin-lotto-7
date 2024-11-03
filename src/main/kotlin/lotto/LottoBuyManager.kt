package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoBuyManager {

    var money: Int = 0
    var userLottos = mutableListOf<List<Int>>()

    fun requestMoney() {
        println(REQUEST_MONEY_MESSAGE)
        money = Console.readLine().toInt()
        println()
    }

    fun buyLottos() {
        val lottoCount = money / LOTTO_PRICE
        println("${lottoCount}${BUY_LOTTOS_MESSAGE}")
        repeat(lottoCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_COUNT).sorted()
            println(numbers)
            userLottos += numbers
        }
        println()
    }

    companion object {
        private const val REQUEST_MONEY_MESSAGE = "구입금액을 입력해 주세요."
        private const val BUY_LOTTOS_MESSAGE = "개를 구매했습니다."
        private const val LOTTO_PRICE = 1000
        private const val LOTTO_RANGE_START = 1
        private const val LOTTO_RANGE_END = 45
        private const val LOTTO_COUNT = 6
    }
}