package lotto.adapter

import lotto.domain.model.BonusNumber
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class BonusNumberAdapterTest {
    @Test
    @DisplayName("보너스 번호 - 유효한 입력은 객체 생성")
    fun `makeBonusNumberModel에 유효한 입력이 들어오면 BonusNumber를 생성해야 한다`() {
        val input = "7"
        val result = BonusNumberAdapter.makeBonusNumberModel(input)

        assertEquals(BonusNumber(7), result)
    }
}