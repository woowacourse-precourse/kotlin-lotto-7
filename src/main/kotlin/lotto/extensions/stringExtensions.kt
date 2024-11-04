package lotto.extensions

fun String.containGap(): Boolean = this.contains(" ")

fun String.isNotNumeric(): Boolean = !this.all { it.isDigit() }

fun String.isBelowMinimumAmount(): Boolean = this.toInt() < 1000

fun String.isNotThousandUnit(): Boolean = this.toInt() % 1000 != 0

fun String.isAboveMaximumAmount(): Boolean = this.length > 7 || (this.length == 7 && this > "1000000")

fun String.splitByComma(): List<String> = this.split(",")

fun String.isNotNumbers(): Boolean = !this.splitByComma().all {
    it.trim().all { char ->
        char.isDigit()
    }
}

fun String.hasNotSixNumbers(): Boolean = this.splitByComma().size != 6

fun String.hasDuplicateNumbers(): Boolean = this.splitByComma().distinct().size != 6

fun String.areNotNumbersInRange(): Boolean = !this.splitByComma().all {
    it.toInt() in 1..45
}

fun String.isNotNumberInRange(): Boolean = this.toInt() !in 1..45

fun String.isDuplicateBonusNumber(winningNumbers: List<Int>): Boolean = this.toInt() in winningNumbers