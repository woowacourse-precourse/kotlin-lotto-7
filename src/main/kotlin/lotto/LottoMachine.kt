package lotto

class LottoMachine {
    fun guideInputLottoPurchaseAmount(): String {
        return "구입금액을 입력해 주세요."
    }

    fun purchase(won: Int): List<Lotto> {
        if (won % 1000 != 0) {
            throw IllegalArgumentException(ErrorMessage.INPUT_AMOUNT_ERROR.getMessage())
        }
        return listOf()
    }
}