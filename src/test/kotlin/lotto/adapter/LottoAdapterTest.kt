package lotto.adapter

import lotto.domain.model.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoAdapterTest {
    @Test
    @DisplayName("로또 - 유효한 입력은 객체 생성")
    fun `makeLottoModel에 유효한 입력이 들어오면 Lotto를 생성해야 한다`() {
        val input = "1,2,3,4,5,6"
        val result = LottoAdapter.makeLottoModel(input)

        assertEquals(Lotto(listOf<Int>(1, 2, 3, 4, 5, 6)), result)
    }
}