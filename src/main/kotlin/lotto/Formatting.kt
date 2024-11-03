package lotto

import java.text.DecimalFormat

class Formatting {
    fun formatRound2(rate: Float): String {
        return "%.1f".format(rate)
    }

    fun formatPrice(price: Int): String {
        return DecimalFormat("#,###").format(price)
    }
}