package lotto

class LottoSalesMachine {
    val lottoPrice = 1000

    fun guideInputLottoPurchaseAmount(): String {
        return "구입금액을 입력해 주세요."
    }

    fun purchase(won: Int): List<Lotto> {
        exceptNotDevideThousand(won)
        val lottoCount = won / 1000
        println("${lottoCount}개를 구매했습니다.")
        return List(lottoCount) { LottoMaker.make() }
    }

    private fun exceptNotDevideThousand(won: Int) {
        if (won % lottoPrice != 0) {
            throw IllegalArgumentException(ErrorMessage.INPUT_AMOUNT_ERROR.getMessage())
        }
    }
}