package lotto

import camp.nextstep.edu.missionutils.Console

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 당첨 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 당첨 번호는 1~45 사이의 숫자여야 합니다." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] 로또 당첨 번호는 중복될 수 없습니다." }
    }

    // TODO: 추가 기능 구현
    companion object {
        fun checkLottoAmount(amount: String): Int {
            val lottoAmount = amount.toIntOrNull()
            when {
                lottoAmount == null -> throw IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.")
                lottoAmount < 0 -> throw IllegalArgumentException("[ERROR] 구입 금액은 양의 정수여야 합니다.")
                lottoAmount % 1000 != 0 -> throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.")
                else -> return lottoAmount / 1000
            }
        }

        fun checkWinningNumber(numbers: String): List<Int> {
            val winningNumbers = if ("," in numbers) {
                numbers.split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .map { it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.")}
            } else { throw IllegalArgumentException("[ERROR] 당첨 번호는 ','를 이용하여 구분하여야 합니다.\n[예시] 1,2,3,4,5,6")}

            when {
                winningNumbers.size != 6 -> throw IllegalArgumentException("[ERROR] 당첨 번호는 6자리의 숫자여야 합니다.")
                winningNumbers.any { it !in 1..45} -> throw IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.")
                winningNumbers.size != winningNumbers.toSet().size -> throw IllegalArgumentException("[ERROR] 당첨 번호는 중복을 허용하지 않습니다.")

            }
            return winningNumbers
        }

        fun checkBonusNumber(number: String, winningNumber: List<Int>): Int? {
            val bonusNumber = number.toIntOrNull()

            when {
                bonusNumber == null -> throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")
                bonusNumber !in 1..45 -> throw IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.")
                bonusNumber in winningNumber -> throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
            }

            return bonusNumber
        }

        fun getLottoInformation() {
            println("구입 금액을 입력해 주세요.")
            val lottoAmount = Console.readLine()
            val validLottoAmount = checkLottoAmount(lottoAmount)

            println("당첨 번호를 입력해 주세요.")
            val winningNumbers = Console.readLine()
            val validWinningNumber = checkWinningNumber(winningNumbers)

            println("보너스 번호를 입력해 주세요.")
            val bonusNumber = Console.readLine()
            val validBonusNUmber = checkBonusNumber(bonusNumber, validWinningNumber)

            println("구매 가능한 로또 개수: $validLottoAmount")
            println("당첨 번호: $winningNumbers")
            println("보너스 번호: ${validBonusNUmber}")
        }
    }
}
