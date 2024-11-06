package lotto

import lotto.utils.LottoGenerator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `기능 테스트-6개의 로또 번호가 생성 되었는지 확인`() {
        val lotto = LottoGenerator.createLotto()
        assertEquals(
            LottoGenerator.LOTTO_ONE_SET_SIZE,
            lotto.size,
            "생성된 로또 번호가 들어있는 리스트의 사이즈가 LOTTO_ONE_SET_SIZE(default = 6)과 동일해야 함"
        )
    }

    @Test
    fun `기능 테스트-1~45 범위내에서 로또 번호들이 생성 되었는지 확인`() {
        val lotto = LottoGenerator.createLotto()
        val validNumberRange = LottoGenerator.LOTTO_START_INCLUSIVE_NUMBER..LottoGenerator.LOTTO_END_INCLUSIVE_NUMBER
        assertTrue(
            { lotto.all { it in validNumberRange } }  ,
            "생성된 로또 번호들은 1~45사이의 정수만 가능"
        )
    }

    @Test
    fun `기능 테스트-생성된 로또 번호에 중복이 없는지 확인`() {
        val lotto = LottoGenerator.createLotto()
        val validLotto = lotto.toSet()
        assertEquals(
            lotto.size,
            validLotto.size,
            "중복없이 랜덤 번호가 생성되어야 함"
        )
    }

    @Test
    fun `기능 테스트-금액에 맞게 로또 수량이 계산되는지 확인`() {
        val count = LottoGenerator.getLottoCount(10000)
        assertEquals(
            10,
            count,
            "로또 수량은 금액/1000개이어야 함"
        )
    }


}