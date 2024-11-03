package lotto.domain.util.ext

fun String.isNumeric(): Boolean {
    return this.all { it.isDigit() }
}

fun String.isThousandUnit(): Boolean {
    return this != "0" && this.toInt() % 1000 == 0
}

fun String.splitByComma(): List<String> {
    return this.split(",")
}