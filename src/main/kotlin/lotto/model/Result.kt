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

    fun revenue(resultNumbers: List<Int>, tryCount: Int): Double{
        val winningAmount: List<Int> = arrayListOf(5000, 50000, 1500000, 30000000, 2000000000)
        var sum: Double = 0.0
        for(i in 0..4){
            sum += resultNumbers[i] * winningAmount[i]
        }
        return sum/(tryCount*1000)*100
    }
}
