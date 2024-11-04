package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoWinningInfoTest {

    @Test
    fun `로또 당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinningInfo(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinningInfo(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 당첨 번호 생성에 성공한다`() {
        val winningInfo = LottoWinningInfo(listOf(1, 2, 3, 4, 5, 6))
        winningInfo.bonusNumber = 7
    }

    @Test
    fun `로또 당첨 번호에 너무 큰 값이 들어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinningInfo(listOf(1, 2, 3, 4, 5, 66))
        }
    }

    @Test
    fun `로또 당첨 보너스 번호에 너무 큰 값이 들어가면 예외가 발생한다`() {
        val winningInfo = LottoWinningInfo(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> {
            winningInfo.bonusNumber = 77
        }
    }

    @Test
    fun `로또 당첨 번호에 너무 작은 값이 들어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinningInfo(listOf(1, -2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `로또 당첨 보너스 번호에 너무 작은 값이 들어가면 예외가 발생한다`() {
        val winningInfo = LottoWinningInfo(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> {
            winningInfo.bonusNumber = -1
        }
    }

    @Test
    fun `로또 당첨 번호가 6개 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinningInfo(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 당첨 번호와 보너스 번호에 같은 숫자가 있으면 예외가 발생한다`() {
        val winningInfo = LottoWinningInfo(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> {
            winningInfo.bonusNumber = 6
        }
    }
}
