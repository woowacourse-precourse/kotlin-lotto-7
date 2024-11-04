package lotto.extensions

fun String.containGap() = this.contains(" ")

fun String.isNotNumeric() = !this.all { it.isDigit() }

fun String.isBelowMinimumAmount() = this.toInt() < 1000

fun String.isNotThousandUnit() = this.toInt() % 1000 != 0

fun String.isAboveMaximumAmount() = this.length > 7 || (this.length == 7 && this > "1000000")