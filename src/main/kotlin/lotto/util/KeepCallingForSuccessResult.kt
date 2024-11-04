package lotto.util

fun <R> keepCallingForSuccessResult(
    onFailure: ((Throwable) -> Unit)? = null,
    actionToCall: () -> Result<R>,
): R {
    while (true) {
        actionToCall().onSuccess { value ->
            return value
        }.onFailure { exception ->
            if (exception is NoSuchElementException) throw exception
            onFailure?.invoke(exception)
        }
    }
}
