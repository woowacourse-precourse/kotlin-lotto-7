package data

import java.util.TreeSet

fun interface LottoDataSource : () -> TreeSet<Int>