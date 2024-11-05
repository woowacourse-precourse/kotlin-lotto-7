package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat


class LottoGameTest {

    // 기능 테스트
    @Test
    fun `유효한 구입 금액을 입력하면 해당 금액을 반환한다`() {
        val game = LottoGame(readLine = { "3000" })
        val cost = game.inputCost()
        assertThat(cost).isEqualTo(3000)
    }

    // 예외 처리 테스트
    @Test
    fun `금액이 1000원 미만이면 예외가 발생후 재입력 받아 정상 종료된다`() {
        val game = LottoGame(readLine = { "900" })
        val exception = assertThrows<IllegalArgumentException> {
            game.parseCost("900")
        }
        assertThat(exception.message).contains("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.")
    }

    // 예외 처리 테스트
    @Test
    fun `금액이 1000 단위가 아니면 예외가 발생한다`() {
        val game = LottoGame(readLine = { "1500" })
        val exception = assertThrows<IllegalArgumentException> {
            game.parseCost("1500")
        }
        assertThat(exception.message).contains("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.")
    }

    // 기능 테스트
    @Test
    fun `유효한 당첨 번호를 입력하면 해당 로또를 반환한다`() {
        val game = LottoGame(readLine = { "1, 2, 3, 4, 5, 6" })
        val winningLotto = game.inputWinningLotto()
        assertThat(winningLotto.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    // 예외 처리 테스트
    @Test
    fun `당첨 번호가 유효하지 않으면 예외가 발생한다`() {
        val game = LottoGame(readLine = { "" })

        val exception = assertThrows<IllegalArgumentException> {
            game.parseWinningLotto("1,2,3,4,5")  // 5개만 입력된 경우
        }
        assertThat(exception.message).contains("[ERROR] 로또 번호는 6개여야 합니다.")
    }

    // 기능 테스트
    @Test
    fun `유효한 보너스 번호를 입력하면 해당 번호를 반환한다`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val game = LottoGame(readLine = { "8" })
        val bonusNumber = game.inputBonusNumber(winningLotto = winningLotto)
        assertThat(bonusNumber).isEqualTo(8)
    }

    // 예외 처리 테스트
    @Test
    fun `보너스 번호가 숫자 형식이 아니면 예외가 발생한다`() {
        val game = LottoGame(readLine = { "" })
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val exception = assertThrows<IllegalArgumentException> {
            game.parseBonusNumber("abc", winningLotto = winningLotto)
        }
        assertThat(exception.message).contains("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.")
    }

    // 예외 처리 테스트
    @Test
    fun `보너스 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다`() {
        val game = LottoGame(readLine = { "" })
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val exception = assertThrows<IllegalArgumentException> {
            game.parseBonusNumber("-3", winningLotto = winningLotto)
        }
        assertThat(exception.message).contains("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.")
    }

    // 예외 처리 테스트
    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        val game = LottoGame(readLine = { "" })
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val exception = assertThrows<IllegalArgumentException> {
            game.parseBonusNumber("6", winningLotto = winningLotto)
        }
        assertThat(exception.message).contains("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
    }

    // 기능 테스트
    @Test
    fun `구입 금액에 따른 로또 목록이 생성된다`() {
        val cost = 3000
        val game = LottoGame(readLine = { "3000" })
        val lottoList = game.buyLottos(cost)
        assertThat(lottoList.size).isEqualTo(cost / 1000)
        lottoList.forEach { lotto ->
            val numbers = lotto.getNumbers()
            assertThat(numbers.size).isEqualTo(6)
            assertThat(numbers.distinct().size).isEqualTo(6)
            assertThat(numbers.all { it in 1..45 }).isTrue()
        }
    }

    // 기능 테스트
    @Test
    fun `로또들과 당첨 로또를 비교하여 각 등수 개수 정확하게 계산`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 9

        val lottoList = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 10, 20, 30, 40, 41)),
            Lotto(listOf(7, 8, 11, 19, 20, 23))
        )
        val game = LottoGame(readLine = { "" })
        val result = game.calculateResult(lottoList,winningLotto, bonusNumber)

        assertThat(result.countRank(LottoRank.FIRST)).isEqualTo(1)
        assertThat(result.countRank(LottoRank.NONE)).isEqualTo(2)
    }
}