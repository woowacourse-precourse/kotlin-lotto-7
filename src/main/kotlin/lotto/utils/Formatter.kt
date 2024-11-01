package lotto.utils

import java.text.DecimalFormat

object Formatter {
    fun decimalFormatter(number: Int): String {
        val decimalFormat = DecimalFormat("#,###")
        return decimalFormat.format(number)
    }
}