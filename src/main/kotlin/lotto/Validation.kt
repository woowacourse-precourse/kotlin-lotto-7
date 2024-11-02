package lotto

class Validation {
    fun checkPayment(payment: String): Int {
        require(isDigit(payment)) { PAYMENTNOTDIGITINSTRUCTION }

        val convertedPayment = payment.toInt()

        require(isPaymentUnder100000(convertedPayment)) { PAYMENTOVERLIMITINSTRUCTION }
        require(isPaymentUnit1000(convertedPayment)) { PAYMENTNOT1000INSTRUCTION }
        return convertedPayment
    }

    fun checkNumbering(lottoNumbers: List<Int>) {
        isAmountOfNumberSix(lottoNumbers)
        isNumbersRange1To45(lottoNumbers)
        isNumbersNotDuplicate(lottoNumbers)
    }

    fun checkWinningNumbers(winningNumbers: List<Int>) {
        isAmountOfNumberSix(winningNumbers)
        isNumbersRange1To45(winningNumbers)
        isNumbersNotDuplicate(winningNumbers)
    }

    fun isDigit(input: String): Boolean {
        input.forEach {
            if (!it.isDigit()) {
                return false
            }
        }
        return true
    }

    fun isZero(number: Int): Boolean {
        return number == 0
    }

    fun isAmountOfNumberSix(numbers: List<Int>) {
        require(numbers.size == 6) { ERRORAMOUNTOFNUMBER }
    }

    fun isNumbersRange1To45(numbers: List<Int>) {
        var validation = true

        numbers.forEach {
            if (!isNumberRange1To45(it)) {
                validation = false
            }
        }
        require(validation) { ERRORNUMBERRANGE }
    }

    fun isNumbersNotDuplicate(numbers: List<Int>) {
        val checkNumbers = numbers.groupingBy { it }.eachCount()
        var validation = true

        checkNumbers.forEach {
            if (it.value > 1) {
                validation = false
            }
        }
        require(validation) { ERRORDUPLICATION }
    }

    private fun isNumberRange1To45(number: Int): Boolean {
        return number in 1..45
    }

    private fun isPaymentUnder100000(payment: Int): Boolean {
        return payment in 0..PURCHASELIMIT
    }

    private fun isPaymentUnit1000(payment: Int): Boolean {
        return payment % SALEUNIT == 0
    }

    companion object {
        const val PURCHASELIMIT = 100000
        const val SALEUNIT = 1000
        const val PAYMENTNOTDIGITINSTRUCTION = "[ERROR] 구입금액은 숫자로 입력해야 합니다."
        const val PAYMENTOVERLIMITINSTRUCTION = "[ERROR] 10만원 구입 한도를 초과하였습니다."
        const val PAYMENTNOT1000INSTRUCTION = "[ERROR] 구입금액은 1000원 단위로 입력해야 합니다. 로또 1장의 가격은 1000원입니다."
        const val ERRORAMOUNTOFNUMBER = "[ERROR] 로또 번호는 6개여야 합니다."
        const val ERRORNUMBERRANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        const val ERRORDUPLICATION = "[ERROR] 로또 번호는 중복될 수 없습니다."
    }
}