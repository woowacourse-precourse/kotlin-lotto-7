package lotto.util

fun String.toIntOrException() =
    this.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 정수 값을 입력해주세요.")