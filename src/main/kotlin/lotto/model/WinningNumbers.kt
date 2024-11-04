package lotto.model

class WinningNumbers(private val mainNumbers: Lotto, private val bonusNumber: LottoNumber) {
    init {
        require(!mainNumbers.containNumber(bonusNumber)) { "[ERROR] 보너스 숫자가 이미 메인 숫자에 포함되어 있습니다" }
    }
}
