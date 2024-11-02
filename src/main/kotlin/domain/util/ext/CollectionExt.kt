package domain.util.ext

import java.util.TreeSet

fun <T> List<T>.toMapByEachCount(): Map<T, Int> {
    return this.groupingBy { it }.eachCount()
}

fun <T> TreeSet<T>.joinToStringWithSquareBracket(): String {
    return this.joinToString(separator = ", ", prefix = "[", postfix = "]")
}