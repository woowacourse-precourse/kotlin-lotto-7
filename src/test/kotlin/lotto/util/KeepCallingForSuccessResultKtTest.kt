package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class KeepCallingForSuccessResultKtTest {
    @Test
    fun `Result가 Success일 경우 정상적으로 값을 반환`() {
        // arrange
        val action = { Result.success(SUCCESS_VALUE) }

        // act
        val returnedValue = keepCallingForSuccessResult(actionToCall = action)

        // assert
        assertThat(returnedValue).isEqualTo(SUCCESS_VALUE)
    }

    @Test
    fun `Result가 Failure일 경우 Success가 반환될 때까지 actionToCall을 호출`() {
        // arrange
        var onFailureCallCounter = 0
        val action = action@{
            if (onFailureCallCounter == MAX_CALL_COUNTER) return@action Result.success(onFailureCallCounter)
            return@action Result.failure<Int>(IllegalArgumentException())
        }

        // act
        val returnedValue = keepCallingForSuccessResult(
            onFailure = { ++onFailureCallCounter },
            actionToCall = action
        )

        // assert
        assertThat(returnedValue).isEqualTo(MAX_CALL_COUNTER)
    }

    companion object {
        private const val SUCCESS_VALUE = 123
        private const val MAX_CALL_COUNTER = 100
    }
}
