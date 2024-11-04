package lotto.util.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoGeneratorValidatorTest {
    @Test
    fun `구입 금액이 1,000원 미만일 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            require(LottoGeneratorValidator.isMoreThanOneThousand(900))
        }
    }

    @Test
    fun `구입 금액이 1,000단위가 아닐 때 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            require(LottoGeneratorValidator.isThousandUnit(1500))
        }
    }

    @Test
    fun `구입 금액이 1,000원 이상일 때 성공 테스트`() {
        assertDoesNotThrow {
            require(LottoGeneratorValidator.isMoreThanOneThousand(1000))
        }
    }

    @Test
    fun `구입 금액이 1,000단위일 때 성공 테스트`() {
        assertDoesNotThrow {
            require(LottoGeneratorValidator.isThousandUnit(2000))
        }
    }
}