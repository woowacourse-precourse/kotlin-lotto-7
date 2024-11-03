package lotto.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BonusNumberTest {
    @Test
    @DisplayName("보너스 모델 생성")
    fun `BonusNumber는 주어진 보너스 번호로 생성되어야 한다`() {
        val bonusNumberValue = 7
        val bonusNumber = BonusNumber(bonusNumberValue)

        assertEquals(bonusNumberValue, bonusNumber.bonusNumber)
    }
}