package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.Exception
import java.lang.NumberFormatException

fun main() {
    println("구입금액을 입력해 주세요.")
    while (true) {
        try {
            val purchaseAmount = Console.readLine().toInt()
            require(purchaseAmount % 1000 == 0) { "[ERROR] 로또는 1,000원 단위로만 구매할 수 있습니다." }
            break
        } catch (e: NumberFormatException) {
            println("[ERROR] 유효한 숫자를 입력해 주세요.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        } catch (e: Exception) {
            println("[ERROR] " + e.message)
        }
    }

}
