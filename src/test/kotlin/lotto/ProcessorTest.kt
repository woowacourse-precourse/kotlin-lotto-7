package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProcessorTest {
    @Test
    fun `문자열로 된 로또 번호 입력을 리스트로 분할해 반환한다`() {
        val processed = Processer().splitLottoNumber("1,2,3,4,5,6")
        Assertions.assertEquals(listOf("1","2","3","4","5","6"), processed)
    }

    @Test
    fun `문자열 리스트로 된 로또 번호를 숫자형 리스트로 변환한다`() {
        val processed = Processer().convertLottoNumber(listOf("1","2","3","4","5","6"))
        Assertions.assertEquals(listOf(1,2,3,4,5,6), processed)
    }
}