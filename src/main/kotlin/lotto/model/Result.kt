package lotto.model

class ResultNumber {
    fun check(numbers: MutableList<MutableList<Int>>, winNumber: List<Int>, bonusNumber: Int): List<Int> {
        val resultCount = MutableList(5) { 0 } // [3개 일치, 4개 일치, 5개 일치, 5개 + 보너스, 6개 일치]

        numbers.forEach { lotto ->
            val matchCount = lotto.count { it in winNumber }

            when (matchCount) {
                3 -> resultCount[0]++
                4 -> resultCount[1]++
                5 -> {
                    if (bonusNumber in lotto) {
                        resultCount[3]++
                    } else {
                        resultCount[2]++
                    }
                }
                6 -> resultCount[4]++
            }
        }

        return resultCount
    }
}
