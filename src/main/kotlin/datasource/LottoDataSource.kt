package datasource

import java.util.TreeSet

fun interface LottoDataSource : () -> TreeSet<Int>