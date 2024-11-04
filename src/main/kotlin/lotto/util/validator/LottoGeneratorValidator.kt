package lotto.util.validator

object LottoGeneratorValidator {
    /** 구입 금액이 1,000원 이상 인지 검사 한다. */
    fun isMoreThanOneThousand(purchasePrice: Int): Boolean = purchasePrice >= 1000

    /** 구입 금액이 1,000원 단위 인지 검사 한다. */
    fun isThousandUnit(purchasePrice: Int): Boolean = purchasePrice % 1000 == 0
}