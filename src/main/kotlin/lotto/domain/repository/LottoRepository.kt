package lotto.domain.repository

import java.util.TreeSet

interface LottoRepository {
    fun generateLottoNumbers(): TreeSet<Int>
}