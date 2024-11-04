package lotto.data.datasource

import java.util.TreeSet

fun interface LottoDataSource : () -> TreeSet<Int>