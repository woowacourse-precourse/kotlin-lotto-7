package lotto.domain.random

fun interface LottoNumberGenerator {
    fun pickLottoNumbers(): List<Int>
}
