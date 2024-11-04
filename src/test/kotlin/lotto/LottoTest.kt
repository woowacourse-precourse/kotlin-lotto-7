package lotto

import lotto.model.Lotto
import lotto.model.LottoResult
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

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 결과 기록 - 6개 일치 시`() {
        LottoResult.reset()
        val winningNum = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val randomLotto = listOf(listOf(2, 1, 6, 4, 5, 3))

        winningNum.getResult(1000, 7, randomLotto)
        assertThat(LottoResult.first).isEqualTo(1)
        assertThat(LottoResult.second).isEqualTo(0)
        assertThat(LottoResult.third).isEqualTo(0)
        assertThat(LottoResult.fourth).isEqualTo(0)
        assertThat(LottoResult.fifth).isEqualTo(0)
        assertThat(LottoResult.priceRatio).isEqualTo(200_000_000.0)
    }

    @Test
    fun `로또 결과 기록 - 5개+보너스 일치 시`() {
        LottoResult.reset()
        val winningNum = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val randomLotto = listOf(listOf(1, 7, 4, 5, 3, 2))

        winningNum.getResult(1000, 7, randomLotto)
        assertThat(LottoResult.first).isEqualTo(0)
        assertThat(LottoResult.second).isEqualTo(1)
        assertThat(LottoResult.third).isEqualTo(0)
        assertThat(LottoResult.fourth).isEqualTo(0)
        assertThat(LottoResult.fifth).isEqualTo(0)
        assertThat(LottoResult.priceRatio).isEqualTo(3_000_000.0)
    }

    @Test
    fun `로또 결과 기록 - 5개 일치 시`() {
        LottoResult.reset()
        val winningNum = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val randomLotto = listOf(listOf(1, 8, 3, 4, 5, 2))

        winningNum.getResult(1000, 7, randomLotto)
        assertThat(LottoResult.first).isEqualTo(0)
        assertThat(LottoResult.second).isEqualTo(0)
        assertThat(LottoResult.third).isEqualTo(1)
        assertThat(LottoResult.fourth).isEqualTo(0)
        assertThat(LottoResult.fifth).isEqualTo(0)
        assertThat(LottoResult.priceRatio).isEqualTo(150_000.0)
    }

    @Test
    fun `로또 결과 기록 - 4개 일치 시`() {
        LottoResult.reset()
        val winningNum = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val randomLotto = listOf(listOf(1, 7, 3, 9, 4, 2))

        winningNum.getResult(1000, 7, randomLotto)
        assertThat(LottoResult.first).isEqualTo(0)
        assertThat(LottoResult.second).isEqualTo(0)
        assertThat(LottoResult.third).isEqualTo(0)
        assertThat(LottoResult.fourth).isEqualTo(1)
        assertThat(LottoResult.fifth).isEqualTo(0)
        assertThat(LottoResult.priceRatio).isEqualTo(5_000.0)
    }

    @Test
    fun `로또 결과 기록 - 3개 일치 시`() {
        LottoResult.reset()
        val winningNum = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val randomLotto = listOf(listOf(1, 7, 3, 9, 8, 2))

        winningNum.getResult(1000, 7, randomLotto)
        assertThat(LottoResult.first).isEqualTo(0)
        assertThat(LottoResult.second).isEqualTo(0)
        assertThat(LottoResult.third).isEqualTo(0)
        assertThat(LottoResult.fourth).isEqualTo(0)
        assertThat(LottoResult.fifth).isEqualTo(1)
        assertThat(LottoResult.priceRatio).isEqualTo(500.0)
    }
}
