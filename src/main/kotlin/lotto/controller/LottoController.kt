package lotto.controller

import lotto.domain.entity.Lotto
import lotto.domain.entity.Lotto.Companion.toLottoNumbers
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView, private val service: LottoService) {
    private var purchasePrice: Int = 0
    private lateinit var winLotto: Lotto
    private var bonusNumber: Int = 0

    fun run() {
        purchasePrice = getValidPurchasePrice(inputView.getPurchasePrice())
        val lottos = service.purchaseLottos(purchasePrice)
        outputView.showRandomLottos(lottos)

        winLotto = getValidWinningLotto(inputView.getWinningNumbers())
        bonusNumber = getValidBonusNumber(inputView.getBonusNumber())

        service.matchAllLotto(winLotto, lottos, bonusNumber)
        outputView.showStatus()

        val resultMoney = service.getResultMoney()
        val profitRate = service.getProfitRate(purchasePrice, resultMoney)
        outputView.showProfitRate(profitRate)
    }

    private fun getValidPurchasePrice(input: String): Int {
        while (true) {
            try {
                require(input.isValidNumber()) { INVALID_INT_NUMBER_EXCEPTION_MSG }
                require(input.toInt() >= MIN_PURCHASE_PRICE && input.toInt() % 1000 == 0) { INVALID_PRICE_RANGE_EXCEPTION_MSG }

                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidWinningLotto(input: String): Lotto {
        // TODO 6개 중 중복된 숫자 들어오면 예외 발생
        while (true) {
            try {
                require(input.isValidNumbers()) { INVALID_NUMBERS_EXCEPTION_MSG }
                val inputNumbers = input.split(DELIMITER).map { it.toInt() }
                return inputNumbers.toLottoNumbers()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidBonusNumber(input: String): Int {
        while (true) {
            try {
                require(input.isValidNumber()) { INVALID_INT_NUMBER_EXCEPTION_MSG }
                require(input.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { OVER_RANGE_EXCEPTION_MSG }

                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
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
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val MIN_PURCHASE_PRICE = 1000

        private const val INVALID_INT_NUMBER_EXCEPTION_MSG = "[ERROR] 유효하지 않은 정수입니다."
        private const val INVALID_NUMBERS_EXCEPTION_MSG = "[ERROR] 유효하지 않은 당첨 번호 리스트입니다."
        private const val OVER_RANGE_EXCEPTION_MSG = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        private const val INVALID_PRICE_RANGE_EXCEPTION_MSG = "[ERROR] 구입 금액은 1000원 이상의 1000으로 나누어지는 금액이어야 합니다."
    }
}