package lotto

import lotto.domain.generator.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 서비스 통합 테스트")
class LottoServiceIntegrationTest {
    private val lottoGenerator = LottoGenerator()
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGame = LottoGame(lottoGenerator, inputView, outputView)

    @Test
    fun `자동 생성된 로또 번호의 유효성 검증`() {
        val lottos = lottoGenerator.createLottos(8000)

        assertThat(lottos).allSatisfy { lotto ->
            assertThat(lotto.getSortedNumbers()).hasSize(6)
            assertThat(lotto.getSortedNumbers()).allMatch { it in 1..45 }
            assertThat(lotto.getSortedNumbers()).doesNotHaveDuplicates()
        }
    }

    @Test
    fun `자동 생성된 당첨 번호의 유효성 검증`() {
        val winningLotto = lottoGenerator.generateWinningLotto()

        assertThat(winningLotto.getWinningNumbers()).hasSize(6)
        assertThat(winningLotto.getWinningNumbers()).allMatch { it in 1..45 }
        assertThat(winningLotto.getWinningNumbers()).doesNotHaveDuplicates()
        assertThat(winningLotto.getBonusNumber()).isGreaterThanOrEqualTo(1)
        assertThat(winningLotto.getBonusNumber()).isLessThanOrEqualTo(45)
        assertThat(winningLotto.getWinningNumbers()).doesNotContain(winningLotto.getBonusNumber())
    }
}
