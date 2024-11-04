package lotto.model

import lotto.util.LottoOutputText
import java.text.DecimalFormat

enum class LottoRank(val price: Int) {
    NOTHING(0),
    THREE_MATCHES(5000),
    FOUR_MATCHES(50000),
    FIVE_MATCHES(1500000),
    FIVE_AND_BONUS_MATCHES(30000000),
    SIX_MATCHES(2000000000);

    fun print(): String = "${this.toDisplayName()} (${this.price.formatCurrency()})"

    private fun toDisplayName(): String =
        when (this) {
            THREE_MATCHES -> LottoOutputText.THREE_MATCHES
            FOUR_MATCHES -> LottoOutputText.FOUR_MATCHES
            FIVE_MATCHES -> LottoOutputText.FIVE_MATCHES
            FIVE_AND_BONUS_MATCHES -> LottoOutputText.FIVE_AND_BONUS_MATCHES
            SIX_MATCHES -> LottoOutputText.SIX_MATCHES
            NOTHING -> LottoOutputText.EMPTY
        }

    private fun Int.formatCurrency(): String {
        val decimalFormat = DecimalFormat(THOUSAND_COMMA)
        return decimalFormat.format(this)
    }
}

fun Int.toLottoRank(): LottoRank =
    when (this) {
        3 -> LottoRank.THREE_MATCHES
        4 -> LottoRank.FOUR_MATCHES
        5 -> LottoRank.FIVE_MATCHES
        6 -> LottoRank.SIX_MATCHES
        else -> LottoRank.NOTHING
    }

private const val THOUSAND_COMMA = "#,###"