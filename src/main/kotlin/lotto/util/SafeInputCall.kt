package lotto.util

inline fun <T> safeInputCall(block: () -> T): T {
    while(true) {
        return runCatching(block).onFailure { e -> println(e.message) }.getOrNull() ?: continue
    }
}