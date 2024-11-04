package lotto.data.repository

import lotto.data.datasource.LottoDataSource
import lotto.domain.repository.LottoRepository
import java.util.TreeSet

class LottoRepositoryImpl(
    private val lottoDataSource: LottoDataSource
) : LottoRepository {
    override fun generateLottoNumbers(): TreeSet<Int> {
        return lottoDataSource()
    }
}