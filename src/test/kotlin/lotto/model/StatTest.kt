package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StatTest {
    @Test
    fun `count 증가가 정상적으로 동작하는지 테스트한다`() {
        val stat = Stat(Rank.SECOND)
        stat.increaseCount()

        assertThat(stat.getCount()).isEqualTo(1)
    }
}