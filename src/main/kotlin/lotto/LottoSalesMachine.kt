package lotto

import camp.nextstep.edu.missionutils.Console

class LottoSalesMachine {
    val lottoPrice = 1000

    fun guideInputLottoPurchaseAmount(): String {
        return INPUT_PURCHASE_AMOUNT_GUIDE
    }

    fun purchase(won: Int): List<Lotto> {
        exceptNotDevideThousand(won)
        val lottoCount = won / lottoPrice
        println("${lottoCount}${PURCHASE_COUNT_GUIDE}")
        return List(lottoCount) { LottoMaker.make() }
    }

    fun processPurchase(): List<Lotto> {
        while (true) try {
            return purchase(inputLottoPurchase())
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun inputLottoPurchase(): Int {
        println(guideInputLottoPurchaseAmount())
        val purchaseAmount = Console.readLine()
        return validateUserInput(purchaseAmount)
    }

    private fun validateUserInput(purchaseAmount: String): Int {
        if (purchaseAmount.matches(Regex(REGEX_INT))) {
            return purchaseAmount.toInt()
        } else {
            throw IllegalArgumentException(ErrorMessage.INPUT_AMOUNT_FORMAT_ERROR.getMessage())
        }
    }

    private fun exceptNotDevideThousand(won: Int) {
        if (won % lottoPrice != 0) {
            throw IllegalArgumentException(ErrorMessage.INPUT_AMOUNT_ERROR.getMessage())
        }
    }

    companion object {
        private const val REGEX_INT: String = "-?\\d+"
        private const val PURCHASE_COUNT_GUIDE: String = "개를 구매했습니다."
        private const val INPUT_PURCHASE_AMOUNT_GUIDE: String = "구입금액을 입력해 주세요."
    }
}