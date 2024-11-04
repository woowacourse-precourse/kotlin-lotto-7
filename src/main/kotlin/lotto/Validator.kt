package lotto

object Validator {
    fun validatePurchaseAmount(purchaseAmount: String) {
        require(purchaseAmount.isNotEmpty()){ "[ERROR] 입력 값이 없습니다." }
        require(purchaseAmount.toIntOrNull() != null){"[ERROR] 입력 값이 정수가 아닙니다."}
        require(purchaseAmount.toInt()>=1000){ "[ERROR] 구매 금액은 1000원이 최소입니다." }
        require(purchaseAmount.toInt()%1000==0){"[ERROR] 구매 금액은 1000원 단위입니다."}
    }

    fun validateWinningNumber(winningNumber: String) {
        require(winningNumber.isNotEmpty()){ "[ERROR] 입력 값이 없습니다." }
        require(winningNumber.split(",").size==6){ "[ERROR] 로또 번호는 6개여야 합니다." }
        winningNumber.split(",").forEach {
            require(it.trim().toIntOrNull()!=null){"[ERROR] 로또 번호는 숫자여야 합니다."}
            require(it.trim().toInt() in 1..45){"[ERROR] 유효하지 않은 범위의 숫자가 포함되어 있습니다."}
        }
        require(winningNumber.split(",").toSet().size == 6) { "[ERROR] 중복된 숫자가 있습니다." }
    }

    fun validateBonusNumber(bonusNumber: String) {
        require(bonusNumber.isNotEmpty()){ "[ERROR] 입력 값이 없습니다." }
        require(bonusNumber.toIntOrNull() != null){"[ERROR] 입력 값이 숫자가 아닙니다."}
        require(bonusNumber.toInt() in 1..45){"[ERROR] 유효하지 않은 범위의 숫자가 포함되어 있습니다."}
        val winningNumber = LottoSystem.getWinningNumber()
        require(bonusNumber.toInt() !in winningNumber) { "[ERROR] 보너스 숫자는 로또 번호와 중복될 수 없습니다." }
    }

}