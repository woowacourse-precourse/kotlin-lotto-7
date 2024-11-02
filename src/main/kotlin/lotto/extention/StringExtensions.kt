package lotto.extention

fun String.parseToIntOrThrow() = requireNotNull(this.toIntOrNull()) { "[ERROR] 숫자만 입력해주세요." }