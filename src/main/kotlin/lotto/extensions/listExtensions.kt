package lotto.extensions

fun <T> List<T>.toFormattedString(): String = this.joinToString(", ", "[", "]")

fun List<String>.toIntList(): List<Int> = this.map { it.toInt() }