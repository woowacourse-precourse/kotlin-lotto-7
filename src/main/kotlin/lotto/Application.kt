package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

fun main() {
    println("구입금액을 입력해 주세요.")
    val price = Console.readLine()
    val count = price.toInt() / 1000
    println("\n${count}개를 구매했습니다.")
    val lottoNumbers = pickUniqueNumbersInRange(1, 45, 6)
    val sortedLottoNumbers = lottoNumbers.sorted()
    println(sortedLottoNumbers)

    println("당첨 번호를 입력해 주세요.")
    val winningNumber = Console.readLine()
    val splitedWinningNumber = winningNumber.split(",")

    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = Console.readLine()

    println("\n당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - 1개\n" +
            "4개 일치 (50,000원) - 0개\n" +
            "5개 일치 (1,500,000원) - 0개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
            "6개 일치 (2,000,000,000원) - 0개")

}
