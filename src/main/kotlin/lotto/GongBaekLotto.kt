package lotto

import camp.nextstep.edu.missionutils.Console

class GongBaekLotto {

    fun start() {
        val purchaseAmount = inputPurchaseAmount()
        val ticketCount = purchaseAmount / LOTTO_PRICE
        val userLottos = generateLottos(ticketCount)
        printLottos(userLottos)

        val (winningNumbers, bonusNumber) = inputWinningNumbers()
        val prizeChecker = PrizeChecker(winningNumbers, bonusNumber)
        val results = prizeChecker.check(userLottos)

        printResults(results)
        printProfitRate(results, purchaseAmount)
    }

    private fun inputPurchaseAmount(): Int {
        while (true) {
            try {
                println("구입금액을 입력해 주세요.")
                val amount =
                    Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 구입 금액은 숫자만 가능합니다.")
                require(amount % LOTTO_PRICE == 0) { "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다." }
                return amount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun generateLottos(count: Int): List<Lotto> {
        return List(count) { LottoGenerator.generate() }
    }

    private fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.getNumbers()) }
    }

    private fun inputWinningNumbers(): Pair<Lotto, Int> {
        while (true) {
            try {
                println("당첨 번호를 입력해 주세요.")
                val numbers = Console.readLine().split(",").map { it.trim().toInt() }
                require(numbers.size == 6) { "[ERROR] 당첨 번호는 6개여야 합니다." }

                println("보너스 번호를 입력해 주세요.")
                val bonus = Console.readLine().toInt()
                require(bonus in 1..45 && bonus !in numbers) { "[ERROR] 보너스 번호는 1~45 사이여야 하며, 당첨 번호와 중복되지 않아야 합니다." }

                return Lotto(numbers) to bonus
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun printResults(results: Map<Result, Int>) {
        println("당첨 통계\n---")
        Result.entries.filter { it != Result.FAILED }.forEach { result ->
            println("${result.matchCount}개 일치${if (result.requiresBonus) ", 보너스 볼 일치 " else " "}(${result.reward.toCurrency()}원) - ${results[result] ?: 0}개")
        }
    }

    private fun Int.toCurrency(): String = "%,d".format(this)

    private fun printProfitRate(results: Map<Result, Int>, purchaseAmount: Int) {
        val totalReward = results.entries.sumOf { (result, count) -> result.reward * count }
        val profitRate = (totalReward.toDouble() / purchaseAmount) * 100
        println("총 수익률은 %.1f%%입니다.".format(profitRate))
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
