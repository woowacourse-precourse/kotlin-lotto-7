package lotto.exception

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoExceptionTest {

    @Test
    @DisplayName("예외 발생 시 [ERROR] 문구와 함께 지정한 예외 문구를 출력할 수 있다")
    fun exceptionMessage() {
        // given
        val expected = "[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다."

        // when && then
        Assertions.assertThatRuntimeException()
            .isThrownBy {
                throw LottoException(ExceptionCode.INVALID_PURCHASE_AMOUNT_UNIT)
            }.withMessage(expected)
    }
}