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
}
