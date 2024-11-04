package lotto

import lotto.constant.ExceptionMessage.ERROR_NOT_NUMBER
import java.text.DecimalFormat

const val COMMA = ","

fun convertInt(text: String): Int {
    return text.trim().toIntOrNull() ?: throw IllegalArgumentException(ERROR_NOT_NUMBER)
}

fun convertListInt(text: String): List<Int> {
    val slice = text.split(COMMA)
    return slice.map { convertInt(it) }.toList()
}

fun formatWon(number: Int): String {
    return DecimalFormat("#,###").format(number)
}
