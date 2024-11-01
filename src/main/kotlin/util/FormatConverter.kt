package util

fun Int.convertWithDigitComma(): String = "%,d".format(this)

fun Double.convertRoundAtTwoDecimal(): String = "%.1f".format(this)

