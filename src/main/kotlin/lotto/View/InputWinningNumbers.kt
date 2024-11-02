package lotto.View

import camp.nextstep.edu.missionutils.Console

fun inputWinningNumbers(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    return try {
        Console.readLine()
            .split(",")
            .map { it.trim().toInt() }
            .also {
                require(it.size == 6) { "[ERROR] 당첨 번호는 6개여야 합니다." }
                require(it.all { num -> num in 1..45 }) { "[ERROR] 번호는 1에서 45 사이여야 합니다." }
            }
    } catch (e: IllegalArgumentException) {
        println(e.message)
        inputWinningNumbers()
    }
}