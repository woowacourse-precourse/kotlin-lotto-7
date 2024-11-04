package lotto

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    fun `로또 번호의 범위가 1 ~ 45에 해당하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto.fromList(listOf(50, 5, 2, 20, 17, 19))
        }
    }
    @Test
    fun `isContain() 번호 확인 리턴 검증`() {
        val lotto = Lotto.fromList(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.isContain(1)).isEqualTo(true)
        assertThat(lotto.isContain(2)).isEqualTo(true)
        assertThat(lotto.isContain(10)).isEqualTo(false)
    }
}
