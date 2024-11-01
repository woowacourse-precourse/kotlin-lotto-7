package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.text.DecimalFormat

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

    val winNumber = Console.readLine().split(",").mapNotNull { it.trim().toIntOrNull() }.toSet()
    require(winNumber.size == 6)
    require(Validation.isValidRange(*winNumber.toIntArray()))

    val bonusNumber = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException()
    require(Validation.isValidRange(bonusNumber))
    require(Validation.isNotDuplicated(winNumber, bonusNumber))

    val rankResult = mutableMapOf<Rank, Int>()
    Rank.entries.forEach {
        rankResult[it] = 0
    }
    lotto.forEach {
        val rank = it.getRank(winNumber, bonusNumber)
        rankResult[rank] = (rankResult[rank]?: 0) + 1
    }

    for(it in rankResult.entries) {
        if (it.key == Rank.NONE) continue
        print("${it.key.matchedNumber}개 일치")
        if(it.key == Rank.SECOND) print(", 보너스 볼 일치")
        println(" (${decimalFormatter(it.key.winningPrice)}원) - ${it.value}개")
    }
}

fun decimalFormatter(number: Int): String {
    val decimalFormat = DecimalFormat("#,###")
    return decimalFormat.format(number)
}