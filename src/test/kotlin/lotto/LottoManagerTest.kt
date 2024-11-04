package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoManagerTest {

    private lateinit var lottoManager: LottoManager

    @BeforeEach
    fun `8개의 로또 티켓 발행 매니저`() {
        lottoManager = LottoManager(8)
    }


}