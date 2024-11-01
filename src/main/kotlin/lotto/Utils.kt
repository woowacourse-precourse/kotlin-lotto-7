package lotto

import java.text.DecimalFormat

const val ERROR_NOT_NUMBER = "[ERROR] 입력 값이 숫자가 아니거나 너무 큽니다."
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
