package lotto.extensions

fun String.containGap() = this.contains(" ")

fun String.isNotNumeric() = !this.all { it.isDigit() }

fun String.isBelowMinimumAmount() = this.toInt() < 1000

fun String.isNotThousandUnit() = this.toInt() % 1000 != 0

fun String.isAboveMaximumAmount() = this.length > 7 || (this.length == 7 && this > "1000000")

fun String.splitByComma() = this.split(",")

fun String.isNotNumbers() = !this.splitByComma().all {
    it.trim().all { char ->
        char.isDigit()
    }
}

fun String.hasNotSixNumbers() = this.splitByComma().size != 6

fun String.hasDuplicateNumbers() = this.splitByComma().distinct().size != 6

fun String.areNotNumbersInRange() = !this.splitByComma().all {
    it.toInt() in 1..45
}