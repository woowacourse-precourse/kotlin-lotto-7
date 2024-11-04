package lotto.util

import java.text.NumberFormat
import java.util.*

val Long.prettyNumberString: String get() = NumberFormat.getNumberInstance(Locale.KOREA).format(this)
val Double.prettyNumberString: String get() = NumberFormat.getNumberInstance(Locale.KOREA).format(this)