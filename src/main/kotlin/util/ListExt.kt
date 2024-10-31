package util

fun<T> List<T>.toMapByEachCount(): Map<T, Int> {
    return this.groupingBy { it }.eachCount()
}