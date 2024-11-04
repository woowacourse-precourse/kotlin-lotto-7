package model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.LottoUtils

class LottoMakerTest {
    @Test
    fun `로또를 발행할 수 있다`() {
        assertSimpleTest {
            // given

            // when
            val lottoTicket = LottoMaker.makeLotto()

            // then
            assertThat(lottoTicket.size).isEqualTo(LottoUtils.LOTTO_NUMBER_COUNTS)
        }
    }

    @Test
    fun `로또는 중복되지 않는 6개의 숫자들로 이뤄진다`() {
        assertSimpleTest {
            // given

            // when
            val lottoTicket = LottoMaker.makeLotto().toSet()

            // then
            assertThat(lottoTicket.size).isEqualTo(LottoUtils.LOTTO_NUMBER_COUNTS)
        }
    }
}