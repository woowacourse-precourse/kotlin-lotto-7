package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTest {
    @Nested
    @DisplayName("당첨 번호 유효성 검증")
    inner class WinningLottoValidation {
        private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        @Test
        fun `보너스 번호는 당첨 번호와 중복될 수 없다`() {
            assertThrows<IllegalArgumentException> {
                WinningLotto(winningNumbers, 1)
            }
        }

        @ParameterizedTest
        @ValueSource(ints = [0, 46])
        fun `보너스 번호는 1부터 45 사이의 숫자여야 한다`(bonusNumber: Int) {
            assertThrows<IllegalArgumentException> {
                WinningLotto(winningNumbers, bonusNumber)
            }
        }

        @Test
        fun `유효한 당첨 번호와 보너스 번호로 당첨 번호를 생성할 수 있다`() {
            val winningLotto = WinningLotto(winningNumbers, 7)
            assertThat(winningLotto.getWinningNumbers()).isEqualTo(winningNumbers)
            assertThat(winningLotto.getBonusNumber()).isEqualTo(7)
        }
    }

    @Nested
    @DisplayName("당첨 결과 계산")
    inner class WinningCalculation {
        private val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)

        @ParameterizedTest
        @CsvSource(
            "1,2,3,4,5,6,FIRST", // 6개 일치
            "1,2,3,4,5,7,SECOND", // 5개 + 보너스
            "1,2,3,4,5,8,THIRD", // 5개 일치
            "1,2,3,4,8,9,FOURTH", // 4개 일치
            "1,2,3,8,9,10,FIFTH", // 3개 일치
            "1,2,8,9,10,11,NONE", // 2개 일치
        )
        fun `당첨 번호 일치 개수에 따라 당첨 결과를 반환한다`(
            n1: Int,
            n2: Int,
            n3: Int,
            n4: Int,
            n5: Int,
            n6: Int,
            expectedRank: Rank,
        ) {
            val userLotto = Lotto(listOf(n1, n2, n3, n4, n5, n6))
            assertThat(winningLotto.match(userLotto)).isEqualTo(expectedRank)
        }
    }
}
