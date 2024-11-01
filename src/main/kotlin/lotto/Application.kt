package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val price = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException()
    require(price > 0)
    require(price % 1000 == 0)

    val lottoCount = price / 1000
    val lotto = mutableListOf<Lotto>()
    lotto.apply {
        repeat(lottoCount) {
            add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
        }
    }
    println(lottoCount)
    lotto.forEach {
        println(it.getNumbers())
    }

    val winNumber = Lotto(Console.readLine().split(",").mapNotNull { it.trim().toIntOrNull() }.distinct())
    require(winNumber.getNumbers().size == 6)
    require(winNumber.isValidRange())
}
