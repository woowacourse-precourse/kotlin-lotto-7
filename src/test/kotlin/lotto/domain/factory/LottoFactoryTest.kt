package lotto.domain.factory

import lotto.data.random.FakeLottoNumberGenerator
import lotto.domain.model.factory.LottoFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LottoFactoryTest {
    private lateinit var sut: LottoFactory

    @Test
    fun `LottoFactory에 주입된 LottoNumberGenerator에서 생성된 값으로 로또 생성`() {
        // arrange
        val lottoNumberGenerator = FakeLottoNumberGenerator().apply {
            nextLottoNumbers = mutableListOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(2, 1, 3, 4, 5, 6),
                listOf(6, 5, 4, 3, 2, 1),
                listOf(23, 4, 33, 12, 20, 44),
                listOf(29, 39, 8, 17, 22, 35)
            )
        }
        sut = LottoFactory(lottoNumberGenerator)

        // act
        val lottoes = sut.createLottoes(lottoNumberGenerator.maxAmount)

        // assert
        val expectedResults = listOf(
            "[1, 2, 3, 4, 5, 6]",
            "[1, 2, 3, 4, 5, 6]",
            "[1, 2, 3, 4, 5, 6]",
            "[4, 12, 20, 23, 33, 44]",
            "[8, 17, 22, 29, 35, 39]"
        )
        lottoes.zip(expectedResults).forEach { (lotto, expectedResult) ->
            assertThat(lotto.toString()).isEqualTo(expectedResult)
        }
    }
}
