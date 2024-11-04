package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호의 숫자 범위를 초과한 경우(1 ~ 45)`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
            Lotto(listOf(0, 2, 3, 4, 5, 6))
            Lotto(listOf(-1, 2, 3, 4, 5, 6))
        }
    }

//    @Test
//    fun `구입한 만큼의 로또 발행하기`() {
//        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
//        assertRandomUniqueNumbersInRangeTest(
//            {
//                assertThat(lotto.issueLotto(3)).isEqualTo(
//                    listOf(
//                        listOf(8, 21, 23, 41, 42, 43),
//                        listOf(3, 5, 11, 16, 32, 38),
//                        listOf(7, 11, 16, 35, 36, 44)
//                    )
//                )
//            },
//            listOf(8, 21, 23, 41, 42, 43),
//            listOf(3, 5, 11, 16, 32, 38),
//            listOf(7, 11, 16, 35, 36, 44)
//        )
//    }
}
