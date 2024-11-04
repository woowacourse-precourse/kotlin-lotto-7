package lotto

import lotto.constant.LottoRank
import lotto.model.Lotto
import lotto.model.WinningLotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import org.assertj.core.api.Assertions.assertThat

class WinningLottoTest {

    @ParameterizedTest
    @MethodSource("provideInvalidWinningLotto")
    fun `당첨 번호는 1 ~ 45 사이에 숫자만 가능하다`(winningLottoInput: String) {
        assertThrows<IllegalArgumentException> {
            WinningLotto(winningLottoInput)
        }
    }

    @Test
    fun `당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto("1, 2, 3, 4, 5, 6, 7")
        }
    }

    @Test
    fun `로또 번호의 개수가 6개가 보다 적으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto("1,2,3,4,5")
        }
    }

    @Test
    fun `당첨 번호가 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto("1,2,3,3,4,5")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "46", "오", "@", "seven"])
    fun `보너스 번호는 1 ~ 45사이에 숫자여야 한다`(bonusNumberInput : String) {
        assertThrows<IllegalArgumentException> {
            // given
            val winningLotto = WinningLotto("1,2,3,4,5,6")

            // when
            winningLotto.setBonusNumber(bonusNumberInput)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5", "6"])
    fun `보너스 번호는 당첨 번호와 중복되어선 안된다`(bonusNumberInput : String) {
        assertThrows<IllegalArgumentException> {
            // given
            val winningLotto = WinningLotto("1,2,3,4,5,6")

            // when
            winningLotto.setBonusNumber(bonusNumberInput)
        }
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbersAndRanks")
    fun `당첨 번호와 보너스 번호에 따라 로또는 올바른 순위를 할당받는다`(pair: Pair<List<Int>, LottoRank> ) {
            // given
            val lotto = Lotto(pair.first)
            val winningLotto = WinningLotto("1,2,3,4,5,6")
            winningLotto.setBonusNumber("7")

            // when
            val lottoRank = winningLotto.getRank(lotto)

            // then
            assertThat(lottoRank).isEqualTo(pair.second)
    }

    companion object {
        @JvmStatic
        fun provideInvalidWinningLotto(): List<String> {
            return listOf(
                "-1,2,3,4,5,6",
                "1,2,3,4,5,46"
            )
        }

        @JvmStatic
        fun provideLottoNumbersAndRanks(): List<Pair<List<Int>, LottoRank>> {
            return listOf(
                Pair(listOf(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
                Pair(listOf(1, 2, 3, 4, 5, 7), LottoRank.SECOND),
                Pair(listOf(1, 2, 3, 4, 5, 8), LottoRank.THIRD),
                Pair(listOf(1, 2, 3, 4, 9, 10), LottoRank.FOURTH),
                Pair(listOf(1, 2, 3, 11, 12, 13), LottoRank.FIFTH),
                Pair(listOf(14, 15, 16, 17, 18, 19), LottoRank.MISS)
            )
        }
    }
}