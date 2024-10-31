package util

fun <T> List<T>.toMapByEachCount(): Map<T, Int> {
    return this.groupingBy { it }.eachCount()
}

fun <T> List<T>.printWithSquareBracket() {
    println(
        this.joinToString(
            separator = ", ",
            prefix = "[",
            postfix = "]"
        )
    )
}