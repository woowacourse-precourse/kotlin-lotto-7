package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrizeTest {

    @Test
    fun `getPrize 메소드가 올바른 상금을 반환해야 한다`() {
        assertEquals(Prize.FIRST, Prize.getPrize(6, false))
        assertEquals(Prize.SECOND, Prize.getPrize(5, true))
        assertEquals(Prize.THIRD, Prize.getPrize(5, false))
        assertEquals(Prize.FOURTH, Prize.getPrize(4, false))
        assertEquals(Prize.FIFTH, Prize.getPrize(3, false))
        assertEquals(Prize.NONE, Prize.getPrize(0, false))
    }
}