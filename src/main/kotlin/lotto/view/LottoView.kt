package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoPrize

object LottoView {
    fun requestPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return Console.readLine().toIntOrNull()?.takeIf { it % 1000 == 0 }
            ?: throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.")
    }

    fun displayPurchasedLottos(lottos: List<List<Int>>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { lotto ->
            println(lotto.sorted())
        }
    }

    fun requestWinningNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine().split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 잘못된 숫자 입력입니다.") }
    }

    fun requestBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")
    }

    fun displayResults(results: Map<LottoPrize, Int>, yield: Double) {
        println("\n당첨 통계")
        println("---")
        results.forEach { (prize, count) ->
            println("${prize.description} (${prize.prizeMoney}원) - ${count}개")
        }
        println("총 수익률은 ${"%.1f".format(yield)}%입니다.")
    }
}
