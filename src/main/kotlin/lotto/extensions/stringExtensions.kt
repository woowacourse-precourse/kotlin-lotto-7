package lotto.extensions

import lotto.global.*

fun String.containGap(): Boolean = this.contains(" ")

fun String.isNotNumeric(): Boolean = !this.all { it.isDigit() }

fun String.isBelowMinimumAmount(): Boolean = this.toInt() < LOTTO_MINIMUM_AMOUNT

fun String.isNotThousandUnit(): Boolean = this.toInt() % LOTTO_PRICE != 0

fun String.isAboveMaximumAmount(): Boolean =
    this.length > LOTTO_MAXIMUM_AMOUNT_LENGTH || (this.length == LOTTO_MAXIMUM_AMOUNT_LENGTH && this > LOTTO_MAXIMUM_AMOUNT)

fun String.splitByComma(): List<String> = this.split(",")

fun String.isNotNumbers(): Boolean = !this.splitByComma().all {
    it.trim().all { char ->
        char.isDigit()
    }
}

fun String.hasNotSixNumbers(): Boolean = this.splitByComma().size != LOTTO_NUMBERS_SIZE

fun String.hasDuplicateNumbers(): Boolean = this.splitByComma().distinct().size != LOTTO_NUMBERS_SIZE

fun String.areNotNumbersInRange(): Boolean = !this.splitByComma().all {
    it.toInt() in LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER
}

fun String.isNotNumberInRange(): Boolean = this.toInt() !in LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER

fun String.isDuplicateBonusNumber(winningNumbers: List<Int>): Boolean = this.toInt() in winningNumbers