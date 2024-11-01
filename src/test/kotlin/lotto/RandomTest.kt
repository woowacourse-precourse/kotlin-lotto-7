package lotto

import lotto.utils.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest

@DisplayName("랜덤 값 테스트케이스")
class RandomTest {
    @DisplayName("1000번 실행 중 중복없이 정렬된 6개의 숫자를 만들지 못한 경우")
    @RepeatedTest(1_000)
    fun sixOfRandomNumberIsUnique() {
        val original = Random.crateLottoNumbers()
        val comparisonTarget = original.distinct().sorted()
        assertEquals(original, comparisonTarget)
        assertEquals(original.size, 6)
    }

    @DisplayName("1000번 실행 중 생성한 번호가 로또 번호 범위를 벗어난 경우")
    @RepeatedTest(1_000)
    fun randomNumberOutRange() {
        val randomNumbers = Random.crateLottoNumbers()
        assertTrue { randomNumbers.all { it in 1..45 } }
    }
}