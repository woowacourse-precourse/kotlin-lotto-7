package lotto.utils

object ValidationUtils {

    fun checkValidInputPurchaseMoney(money: String) {
        try {
            val validMoney = money.toInt()
            require(validMoney % 1000 == 0) {
                "[ERROR] 구입 금액은 1000단위의 양수만 입력 가능합니다."
            }
            require(validMoney > 0) {
                "[ERROR] 구입 금액은 1000단위의 양수만 입력 가능합니다."
            }
            require(validMoney <= 1000000) {
                "[ERROR] 한번에 구입 가능한 최대 금액은 1,000,000원을 넘길 수 없습니다."
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 1000단위의 양수만 입력 가능합니다.")
        }
    }

    fun checkValidLottoNumbers(numbers: List<Int>) {
        require(numbers.size == 6 ) {
            "[ERROR] 로또 번호는 6개여야 합니다."
        }
        require(numbers.all { it in 1..45 }) {
            "[ERROR] 로또 번호는 1~45 사이의 정수만 가능합니다."
        }
        require(numbers.size == numbers.toSet().size) {
            "[ERROR] 로또 번호는 중복될 수 없습니다."
        }
    }

    fun checkValidWinningNumbers(numbers: String, separator: String) {
        try {
            val validNumbers = numbers.split(separator).map { it.toInt() }
            require(validNumbers.size == 6 ) {
                "[ERROR] 당첨 번호는 6개여야 합니다."
            }
            require(validNumbers.all { it in 1..45 }) {
                "[ERROR] 당첨 번호는 1~45 사이의 정수만 입력 가능합니다."
            }
            require(validNumbers.size == validNumbers.toSet().size) {
                "[ERROR] 당첨 번호는 중복될 수 없습니다."
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("[ERROR] 당첨 번호는 공백없이 1~45 이내의 양의 정수만 공백 없이 $separator 구분으로 입력 가능합니다.")
        }
    }

    fun checkValidBonusNumber(number: String, winningNumbers: List<Int>) {
        try {
            val validBonusNumber = number.toInt()
            require(validBonusNumber in 1..45 ) {
                "[ERROR] 보너스 번호는 1~45 사이의 정수만 가능합니다."
            }
            require(validBonusNumber !in winningNumbers) {
                "[ERROR] 보너스 번호와 당첨 번호는 중복될 수 없습니다."
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("보너스 번호는 공백 없이 1~45 사이의 정수만 입력 가능합니다.")
        }
    }

}