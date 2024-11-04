package lotto

class Validator {
    companion object {
        fun validatePurchaseAmount(amount: String): Int {
            val purchaseAmount = parseAmount(amount)
            checkAmountIsAboveMinimum(purchaseAmount)
            checkAmountIsDivisibleByThousand(purchaseAmount)
            return purchaseAmount
        }

        private fun parseAmount(amount: String): Int {
            return amount.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.")
        }

        private fun checkAmountIsAboveMinimum(amount: Int) {
            require(amount >= 1000) { "[ERROR] 구입 금액은 1000원 이상이어야 합니다." }
        }

        private fun checkAmountIsDivisibleByThousand(amount: Int) {
            require(amount % 1000 == 0) { "[ERROR] 구입 금액은 1000원 단위로 나누어 떨어져야 합니다." }
        }

        fun validateLottoNumbers(input: String): List<Int> {
            checkInputNotBlank(input)
            val numbers = parseLottoNumbers(input)
            checkLottoNumbersAreUnique(numbers)
            checkLottoNumbersRange(numbers)
            return numbers
        }

        private fun checkInputNotBlank(input: String) {
            require(input.isNotBlank()) { "[ERROR] 로또 번호를 입력해 주세요." }
        }

        private fun parseLottoNumbers(input: String): List<Int> {
            return input.split(",").map { it.trim() }
                .map { it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력할 수 있습니다.") }
        }

        private fun checkLottoNumbersAreUnique(numbers: List<Int>) {
            require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
            require(numbers.toSet().size == 6) { "[ERROR] 로또 번호는 중복될 수 없습니다." }
        }

        private fun checkLottoNumbersRange(numbers: List<Int>) {
            require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        }

        fun validateBonusNumber(input: String): Int {
            checkInputNotBlank(input)
            return input.toIntOrNull()?.takeIf { it in 1..45 }
                ?: throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }
}
