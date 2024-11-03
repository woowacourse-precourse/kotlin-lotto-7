package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto.LottoErrorMessages

class InputView {
    fun getPrice(): Int {
        println("구입금액을 입력해 주세요.")
        while (true) {
            try {
                val price = Console.readLine().toInt()
                require(price >= 1000) { "로또 한 개의 가격은 1000원 이상이어야 합니다" }
                return price
            } catch (e: NumberFormatException) {
                println("[ERROR]: 입력은 숫자여야 합니다")
            } catch (e: IllegalArgumentException) {
                println("[ERROR]: ${e.message}")
            }
        }
    }

    fun getLottoNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        while (true) {
            try {
                val input = Console.readLine().split(",").map { it.trim().toInt() }

                // 입력 검증 로직: 각 조건에 맞는 예외를 던지도록 추가
                requireNotNull(input) { "[ERROR]: 입력이 null입니다. 다시 입력해 주세요." }
                require(input.size == 6) { "[ERROR]: 번호는 6개여야 합니다." }
                require(input.distinct().size == input.size) { "[ERROR]: 중복된 번호가 있습니다." }
                require(input.all { it in 1..45 }) { "[ERROR]: 모든 번호는 1~45 사이여야 합니다." }
                require(input == input.sorted()) { "[ERROR]: 번호는 오름차순으로 입력해야 합니다." }

                return input // 입력이 유효하면 반환

            } catch (e: Exception) {
                println(e.message) // 예외 메시지를 출력
            }
        }
    }

    fun getBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        while (true) {
            try {
                val bonusNumber = Console.readLine().toInt()
                require(bonusNumber in 1..45) { LottoErrorMessages.OUT_OF_RANGE }
                return bonusNumber
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("[ERROR]: 입력은 숫자여야 합니다")
            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException("[ERROR]: ${e.message}")
            }
        }
    }
}