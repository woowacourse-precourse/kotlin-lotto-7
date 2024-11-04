package lotto.domain.util

import lotto.domain.enums.Output.Companion.purchaseFormat
import lotto.domain.enums.Rank
import lotto.domain.util.ext.joinToStringWithSquareBracket
import java.util.TreeSet

fun formatWinningResult(winning: Map<Rank, Int>): String =
    winning.map { (rank, count) ->
        rank.getFormattedRankResult(count)
    }.joinToString("\n")

fun formatPurchasedLotto(pickedLotto: List<TreeSet<Int>>): String =
    pickedLotto.joinToString(",\n") {
        it.joinToStringWithSquareBracket()
    }

fun formatPurchaseInfo(purchaseLottoCount: Int): String = purchaseFormat(purchaseLottoCount)