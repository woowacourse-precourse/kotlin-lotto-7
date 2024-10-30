package util

fun String.isNumeric(): Boolean{
    return this.toIntOrNull() != null
}