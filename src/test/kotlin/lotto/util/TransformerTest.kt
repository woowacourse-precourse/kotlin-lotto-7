package lotto.util

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class TransformerTest {

    @Test
    fun `문자열 목록이 올바르게 정수 목록으로 변환된다`() {
        val stringList = listOf("1", "2", "3", "4", "5", "6")
        val result = Transformer().stringToIntInt(stringList)

        assertEquals(listOf(1, 2, 3, 4, 5, 6), result, "변환 결과가 예상과 다릅니다.")
    }
}