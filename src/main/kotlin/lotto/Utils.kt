package lotto

const val ERROR_NOT_NUMBER = "[ERROR] 입력 값이 숫자가 아니거나 너무 큽니다."

fun convertInt(text: String): Int {
    return text.trim().toIntOrNull() ?: throw IllegalArgumentException(ERROR_NOT_NUMBER)
}