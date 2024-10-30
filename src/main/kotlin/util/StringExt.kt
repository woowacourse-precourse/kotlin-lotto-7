package util

fun String.isNumeric(): Boolean{
    return this.toIntOrNull() != null
}

fun String.isOverIntMaxValue(): Boolean{
    val value = this.toLong()
    return value in Int.MIN_VALUE until  Int.MAX_VALUE
}