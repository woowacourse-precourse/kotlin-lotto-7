package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.Exception
import java.lang.NumberFormatException

fun main() {
    var purchaseAmount: Int

    while (true) {
        try {
            println("구입금액을 입력해 주세요.")
            purchaseAmount = Console.readLine().toInt()
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

    val numberOfLottos = purchaseAmount / 1000
    val lottos = List(numberOfLottos) {
        Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
    }
    println("${numberOfLottos}개를 구매했습니다.")
    lottos.forEach { println(it) }
}
