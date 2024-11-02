package lotto

class LottoSalesMachine {
    val lottoPrice = 1000

    fun guideInputLottoPurchaseAmount(): String {
        return "구입금액을 입력해 주세요."
    }

    fun purchase(won: Int): List<Lotto> {
        exceptNotDevideThousand(won)
        return List(won / 1000) { LottoMaker.make() }
    }

    private fun exceptNotDevideThousand(won: Int) {
        if (won % lottoPrice != 0) {
            throw IllegalArgumentException(ErrorMessage.INPUT_AMOUNT_ERROR.getMessage())
        }
    }
}