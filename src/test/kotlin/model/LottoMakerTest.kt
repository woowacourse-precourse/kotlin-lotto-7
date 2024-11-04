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
            val lottoTicket = LottoMaker.makeLotto().getLottoTicket().split(",")

            // then
            assertThat(lottoTicket).isEqualTo(LottoUtils.LOTTO_NUMBER_COUNTS)
        }
    }
}