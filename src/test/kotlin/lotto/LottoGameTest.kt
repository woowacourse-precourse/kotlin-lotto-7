package lotto

import lotto.model.LottoGame
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested

class LottoGameTest {
    private val lottoGame = LottoGame()
    val error = "[ERROR]"

    @Nested
    inner class `올바른 입력` {
        @Test
        @DisplayName("LottoGame class의 validateNumbers 메서드 검증")
        fun `올바른 로또의 당첨 번호 입력을 확인한다`() {
            // given
            val winningLotto = "1,2,3,4,5,6"
            val result = null

            // when
            val winningCount = lottoGame.validateNumbers(winningLotto)

            // then
            assertThat(winningCount).isEqualTo(result)
        }

        @Test
        @DisplayName("LottoGame class의 validateBonus 메서드 검증")
        fun `올바른 보너스 번호 입력을 확인한다`() {
            // given
            val bonusBall = "45"
            val expectedResult = null

            // when
            val result = lottoGame.validateBonus(bonusBall)

            // then
            assertThat(result).isEqualTo(expectedResult)
        }

        @Test
        @DisplayName("LottoGame class의 validateMoney 메서드 검증")
        fun `올바른 구매금액 입력을 검증한다`() {
            // given
            val price = "3000"
            val expectedResult = null

            // when
            val result = lottoGame.validateMoney(price)

            // then
            assertThat(result).isEqualTo(expectedResult)
        }
    }

    @Nested
    inner class `예외 validateNumber` {
        @Test
        fun `당첨 번호 예외 입력을 확인한다 - 문자열`() {
            // given
            val winningLotto = "a,b,c,d,e,f"

            // when
            val winningCount = lottoGame.validateNumbers(winningLotto)

            // then
            assertThat(winningCount).contains(error)
        }

        @Test
        fun `당첨 번호 예외 입력을 확인한다 - 번호 3개`() {
            // given
            val winningLotto = "1,2,3"

            // when
            val winningCount = lottoGame.validateNumbers(winningLotto)

            // then
            assertThat(winningCount).contains(error)
        }

        @Test
        fun `당첨 번호 예외 입력을 확인한다 - 숫자 1보다 작음`() {
            // given
            val winningLotto = "1,2,3,4,5,0"

            // when
            val winningCount = lottoGame.validateNumbers(winningLotto)

            // then
            assertThat(winningCount).contains(error)
        }

        @Test
        fun `당첨 번호 예외 입력을 확인한다 - 숫자 45보다 큼`() {
            // given
            val winningLotto = "1,2,3,4,5,46"

            // when
            val winningCount = lottoGame.validateNumbers(winningLotto)

            // then
            assertThat(winningCount).contains(error)
        }
    }

    @Nested
    inner class `예외 validateBonus` {
        @Test
        fun `보너스 번호 예외 입력을 확인한다 - 문자열`() {
            // given
            val bonus = "a"

            // when
            val winningCount = lottoGame.validateBonus(bonus)

            // then
            assertThat(winningCount).contains(error)
        }

        @Test
        fun `보너스 번호 예외 입력을 확인한다 - 번호 여러 개`() {
            // given
            val bonus = "1,2,3"

            // when
            val winningCount = lottoGame.validateBonus(bonus)

            // then
            assertThat(winningCount).contains(error)
        }

        @Test
        fun `보너스 번호 예외 입력을 확인한다 - 번호 1보다 작음`() {
            // given
            val bonus = "0"

            // when
            val winningCount = lottoGame.validateBonus(bonus)

            // then
            assertThat(winningCount).contains(error)
        }

        @Test
        fun `당첨 번호 예외 입력을 확인한다 - 번호 45보다 큼`() {
            // given
            val bonus = "46"

            // when
            val winningCount = lottoGame.validateBonus(bonus)

            // then
            assertThat(winningCount).contains(error)
        }
    }

    @Nested
    inner class `validateMoney 검증 예외` {
        @Test
        fun `구매금액 입력을 예외를 검증한다 - 문자열`() {
            // given
            val price = "삼천원"

            // when
            val result = lottoGame.validateMoney(price)

            // then
            assertThat(result).contains(error)
        }

        @Test
        fun `구매금액 입력을 예외를 검증한다 - 천원 미만 단위 포함`() {
            // given
            val price = "3600"

            // when
            val result = lottoGame.validateMoney(price)

            // then
            assertThat(result).contains(error)
        }

        @Test
        fun `구매금액 입력을 예외를 검증한다 - 천원 미만`() {
            // given
            val price = "600"

            // when
            val result = lottoGame.validateMoney(price)

            // then
            assertThat(result).contains(error)
        }

        @Test
        fun `구매금액 입력을 예외를 검증한다 - 십만원 이상`() {
            // given
            val price = "101000"

            // when
            val result = lottoGame.validateMoney(price)

            // then
            assertThat(result).contains(error)
        }
    }
}
