package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

fun main() {
    var lotteys: MutableList<List<Int>> = mutableListOf()
    val winningCount: MutableMap<String, Int> = mutableMapOf("1등" to 0, "2등" to 0,
        "3등" to 0, "4등" to 0, "5등" to 0)

    println("구입금액을 입력해 주세요.")
    val price = Console.readLine()
    val count = price.toInt() / 1000
    println("\n${count}개를 구매했습니다.")

    repeat(count) {
        val lottoNumbers = pickUniqueNumbersInRange(1, 45, 6)
        val sortedLottoNumbers = lottoNumbers.sorted()
        println(sortedLottoNumbers)
        lotteys.add(sortedLottoNumbers)
    }

    println(lotteys)

    println("당첨 번호를 입력해 주세요.")
    val winningNumber = Console.readLine()
    val splitedWinningNumber = winningNumber.split(",")

    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = Console.readLine()

    for (lottey in lotteys) {
        var win = 0
        for (lotto in lottey) {
            if (splitedWinningNumber.contains(lotto.toString())) {
                win += 1
            }
        }
        if (win == 5) {
            for (lotto in lottey) {
                if (bonusNumber.toInt() == lotto) {
                    win = -1
                }
            }
        }
        when(win) {
            6 -> winningCount["1등"] = winningCount["1등"]!! + 1
            5 -> {
                winningCount["3등"] = winningCount["3등"]!! + 1
            }
            4 -> winningCount["4등"] = winningCount["4등"]!! + 1
            3 -> winningCount["5등"] = winningCount["5등"]!! + 1
            -1 -> winningCount["2등"] = winningCount["2등"]!! + 1
        }
    }

    println("\n당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${winningCount["5등"]}개\n" +
            "4개 일치 (50,000원) - ${winningCount["4등"]}개\n" +
            "5개 일치 (1,500,000원) - ${winningCount["3등"]}개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningCount["2등"]}개\n" +
            "6개 일치 (2,000,000,000원) - ${winningCount["1등"]}개")
}
