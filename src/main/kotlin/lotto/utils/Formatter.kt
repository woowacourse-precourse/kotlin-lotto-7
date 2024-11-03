package lotto.utils

import java.text.DecimalFormat

object Formatter {
    fun addCommas(number: Int): String {
        val decimalFormat = DecimalFormat("#,###")
        return decimalFormat.format(number)
    }

    fun addCommasToDecimal(number: Double): String {
        val decimalFormat = DecimalFormat("#,###.0")
        return decimalFormat.format(number)
    }
}