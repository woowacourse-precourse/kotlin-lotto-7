package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val price = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException()
    require(price > 0)
    require(price % 1000 == 0)
}
