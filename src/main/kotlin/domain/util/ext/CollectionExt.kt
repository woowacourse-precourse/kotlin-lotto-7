package domain.util.ext

import java.util.TreeSet

fun <T> List<T>.toMapByEachCount(): Map<T, Int> {
    return this.groupingBy { it }.eachCount()
}

fun <T> List<T>.mapToInt(): List<Int> {
    return this.map { it.toString().toInt() }
}

fun <T> TreeSet<T>.joinToStringWithSquareBracket(): String {
    return this.joinToString(separator = ", ", prefix = "[", postfix = "]")
}

