package lotto.extention

private const val ERROR_MESSAGE_INVALID_NUMBER = "[ERROR] 숫자만 입력해주세요."

fun String.parseToIntOrThrow() = requireNotNull(this.toIntOrNull()) { ERROR_MESSAGE_INVALID_NUMBER }