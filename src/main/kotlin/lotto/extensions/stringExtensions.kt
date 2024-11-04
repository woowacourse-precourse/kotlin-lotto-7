package lotto.extensions

import lotto.global.LOTTO_MAXIMUM_AMOUNT
import lotto.global.LOTTO_MINIMUM_AMOUNT
import lotto.global.LOTTO_PRICE

fun String.containGap(): Boolean = this.contains(" ")

fun String.isNotNumeric(): Boolean = !this.all { it.isDigit() }

fun String.isBelowMinimumAmount(): Boolean = this.toInt() < LOTTO_MINIMUM_AMOUNT

fun String.isNotThousandUnit(): Boolean = this.toInt() % LOTTO_PRICE != 0

fun String.isAboveMaximumAmount(): Boolean = this.length > 7 || (this.length == 7 && this > LOTTO_MAXIMUM_AMOUNT)

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