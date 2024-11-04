package lotto.model

class WinningLotto(val lotto: Lotto, val bonusNumber: Int) {

    init {
        require(!lotto.getNumbers().contains(bonusNumber)) { "[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다." }
        require(bonusNumber in MINIMUM_BONUS_NUMBER..MAXIMUM_BONUS_NUMBER) { "[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다." }
    }

    companion object {
        private const val MINIMUM_BONUS_NUMBER = 1
        private const val MAXIMUM_BONUS_NUMBER = 45
    }
}