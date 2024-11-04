package lotto.domain

import lotto.domain.model.LottoWinPlace

private const val PERCENT = 100

fun calculateProfitRate(budget: Int, lottoWinPlaces: Map<LottoWinPlace, Int>): Float {
    val totalPrize = lottoWinPlaces.map { (lottoWinPlace, count) -> lottoWinPlace.prize * count }.sum().toFloat()
    return (totalPrize / budget) * PERCENT
}

