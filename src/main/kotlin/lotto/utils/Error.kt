package lotto.utils

import lotto.constants.LottoConstants.COMMA

object Error {

    fun priceError(purchasePrice: String): Boolean {
        val price = purchasePrice.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 구입금액은 숫자만 가능합니다.")
        if (price % 1000 != 0)
            throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위만 가능합니다.")
        if (price < 1000)
            throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이여야 합니다.")

        return false
    }

    fun winningNumberError(winningNumbers: String): Boolean {
        val numbers = winningNumbers.split(COMMA)
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 가능합니다.") }
        if (numbers.size != 6)
            throw IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다")
        if (numbers.toSet().size != 6)
            throw IllegalArgumentException("[ERROR] 당첨 번호는 중복된 숫자가 없어야 합니다.")

        return false
    }

    fun bonusNumberError(bonusNumber: String): Boolean {
        val number = bonusNumber.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")
        if (number !in 1..45)
            throw IllegalArgumentException("\"[ERROR] 보너스 번호는 1-45 사이 입니다.\"")

        return false
    }
}
