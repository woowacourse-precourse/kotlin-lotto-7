package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

val LOTTO_PRICE = 1000
val LOTTO_MIN = 1
val LOTTO_MAX = 45

fun main() {
    // TODO: 프로그램 구현

    // [1] 구입 금액 입력 및 로또 구매
    val purchaseAmount = Input.purchasePrice()
    val lottoCount = purchaseAmount / LOTTO_PRICE
    println("\n" + lottoCount.toString() + "개를 구매했습니다.")

    // [2] 로또 발행 후 시각화
    val lottoManager = LottoManager(lottoCount)
    lottoManager.showLottoTickets()

    // [3] 당첨 번호 및 보너스 번호 입력
    val winningNumber = Input.setWinningNumber()
    val bonusNumber = Input.setBonusNumber()

    // [4] 당첨 결과 및 통계 시각화
    lottoManager.compareResults(winningNumber, bonusNumber)

}

// [#] 입력 기능 싱글톤 객체
object Input {
    // [*] 구매 금액 입력 기능
    fun purchasePrice(): Int {
        while (true) {
            try {
                println("구입금액을 입력해 주세요.")
                val input = Console.readLine()
                    ?.takeIf { it.isNotBlank() }
                    ?: throw IllegalArgumentException("[ERROR] 입력 값을 다시 확인해주세요.")
                val price = input.toInt()
                require(price % LOTTO_PRICE == 0 && price > 0) { "[ERROR] 구매 금액을 올바르게 입력해주세요." }
                return price
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    // [*] 당첨 번호 입력 기능, 공백 허용
    fun setWinningNumber(): List<Int> {
        while (true) {
            try {
                println("당첨 번호를 입력해 주세요.")
                val winningNumber = Console.readLine().split(",").map { it.trim().toInt() }
                require(winningNumber.size == 6) { "[ERROR] 당첨 번호는 6개여야 합니다." }
                require(winningNumber.all { it in LOTTO_MIN..LOTTO_MAX }) { "[ERROR] 1에서 45 사이의 숫자만 입력 가능합니다." }
                require(winningNumber.toSet().size == 6) { "[ERROR] 중복 없는 6개 번호를 입력해주세요." }
                return winningNumber
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    // [*] 보너스 번호 입력 기능
    fun setBonusNumber(): Int {
        while (true) {
            try {
                println("\n보너스 번호를 입력해 주세요.")
                val input = Console.readLine()
                    ?.takeIf { it.isNotBlank() }
                    ?: throw IllegalArgumentException("[ERROR] 입력 값을 다시 확인해주세요.")
                val bonusNumber = input.toInt()
                require(bonusNumber in LOTTO_MIN..LOTTO_MAX) { "[ERROR] 보너스 번호 값을 다시 확인해주세요." }
                return bonusNumber
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}
