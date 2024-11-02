package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `로또 구입 금액이 로또 1장의 구매 가격의 배수가 아니면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) { LottoMachine(0) }
    }
}