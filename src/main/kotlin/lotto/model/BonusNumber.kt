package lotto.model

import lotto.view.LottoView

class BonusNumber(private val lottoView: LottoView) {
    fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            val bonusNumber = lottoView.readBonusNumber() // LottoView의 메서드 사용
            if (isValidateBonusNumber(bonusNumber, winningNumbers)) {
                return bonusNumber
            }
        }
    }

    private fun isValidateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>): Boolean {
        return when {
            bonusNumber < 1 || bonusNumber > 45 -> {
                println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
                false
            }
            bonusNumber in winningNumbers -> {
                println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
                false
            }
            else -> true
        }
    }
}
