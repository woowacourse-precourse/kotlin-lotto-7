package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호의 개수가 6개보다 적으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호가 1부터 45 사이의 숫자가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
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
}

class LottoGameTest {
    @Nested
    inner class RankTest {
        private val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        private val bonusNumber = 7

        @Test
        fun `6개 번호 일치시 1등`() {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val rank = calculateRank(lotto, winningNumbers, bonusNumber)
            assertThat(rank).isEqualTo(Rank.FIRST)
        }

        @Test
        fun `5개 번호 일치와 보너스 번호 일치시 2등`() {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
            val rank = calculateRank(lotto, winningNumbers, bonusNumber)
            assertThat(rank).isEqualTo(Rank.SECOND)
        }

        @Test
        fun `5개 번호 일치시 3등`() {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
            val rank = calculateRank(lotto, winningNumbers, bonusNumber)
            assertThat(rank).isEqualTo(Rank.THIRD)
        }

        @Test
        fun `4개 번호 일치시 4등`() {
            val lotto = Lotto(listOf(1, 2, 3, 4, 8, 9))
            val rank = calculateRank(lotto, winningNumbers, bonusNumber)
            assertThat(rank).isEqualTo(Rank.FOURTH)
        }

        @Test
        fun `3개 번호 일치시 5등`() {
            val lotto = Lotto(listOf(1, 2, 3, 8, 9, 10))
            val rank = calculateRank(lotto, winningNumbers, bonusNumber)
            assertThat(rank).isEqualTo(Rank.FIFTH)
        }

        @Test
        fun `2개 이하 번호 일치시 꽝`() {
            val lotto = Lotto(listOf(1, 2, 8, 9, 10, 11))
            val rank = calculateRank(lotto, winningNumbers, bonusNumber)
            assertThat(rank).isEqualTo(Rank.NONE)
        }

        private fun calculateRank(lotto: Lotto, winningNumbers: Set<Int>, bonusNumber: Int): Rank {
            val matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers)
            val hasBonus = lotto.getNumbers().contains(bonusNumber)
            return determineRank(matchCount, hasBonus)
        }

        private fun countMatchingNumbers(numbers: List<Int>, winningNumbers: Set<Int>): Int {
            var count = 0
            for (number in numbers) {
                if (winningNumbers.contains(number)) {
                    count++
                }
            }
            return count
        }

        private fun determineRank(matchCount: Int, hasBonus: Boolean): Rank = when {
            matchCount == 6 -> Rank.FIRST
            matchCount == 5 && hasBonus -> Rank.SECOND
            matchCount == 5 -> Rank.THIRD
            matchCount == 4 -> Rank.FOURTH
            matchCount == 3 -> Rank.FIFTH
            else -> Rank.NONE
        }
    }

    @Nested
    inner class ValidationTest {
        @Test
        fun `구입 금액이 1000원 미만일 경우 예외가 발생한다`() {
            val game = LottoGame()
            assertThatThrownBy { game.validateAmount(500) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Message.ERROR_INVALID_MINIMUM_AMOUNT)
        }

        @Test
        fun `구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다`() {
            val game = LottoGame()
            assertThatThrownBy { game.validateAmount(1500) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Message.ERROR_INVALID_AMOUNT)
        }

        @Test
        fun `보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다`() {
            val game = LottoGame()
            val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
            assertThatThrownBy { game.validateBonusNumberDuplicate(1, winningNumbers) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Message.ERROR_DUPLICATE_BONUS_NUMBER)
        }
    }

    @Test
    fun `수익률 계산 테스트`() {
        val game = LottoGame()
        val result = mapOf(
            Rank.FIFTH to 1,  // 5,000원
            Rank.FOURTH to 1  // 50,000원
        )

        assertThat(game.calculateProfitRate(result)).isEqualTo(2750.0)
    }
}
