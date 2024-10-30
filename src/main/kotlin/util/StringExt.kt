package util

fun String.isNumeric(): Boolean{
    return this.toIntOrNull() != null
}

fun String.isThousandUnit(): Boolean{
    return this != "0" && this.toInt() % 1000 == 0
}