package lotto.util

import lotto.constants.Exceptions.INVALID_NUMBER

fun String.toIntOrException() =
    this.toIntOrNull() ?: throw IllegalArgumentException(INVALID_NUMBER)