package lotto.controller

import lotto.view.InputView

class LottoController(val view: InputView) {
    private var price: Int = 0
    private var winLotto = emptyList<Int>()

    private fun getValidPurchasePrice(): Int {
        while (true) {
            val input = view.getPurchasePrice()
            try {
                require(!input.isValidNumber())
                require(!input.isZero())

                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] 0 이상인 정수여야 합니다.")
            }
        }
    }

    private fun getValidWinningNumbers(): List<Int> {
        while (true) {
            val input = view.getWinningNumbers()
            try {
                require(!input.isValidNumbers())
                return input.split(DELIMITER).map { it.toInt() }
            } catch (e: NumberFormatException) {
                println("[ERROR] 유효하지 않은 당첨 번호 리스트입니다.")
            }
        }
    }

    companion object {
        private fun String.isValidNumber() = this.all { it.isDigit() }

        private fun String.isZero() = this.toInt() == 0

        private fun String.isValidNumbers(): Boolean =
            try {
                this.split(',').map { it.toInt() }
                true
            } catch (e: NumberFormatException) {
                false
            }

        private const val DELIMITER = ','
    }
}