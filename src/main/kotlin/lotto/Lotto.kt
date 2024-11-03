package lotto


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] 숫자는 중복이 불가합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 숫자 범위가 아닙니다." }
    }

    fun checkBonusNum(bonusNum: Int) {
        for (i in numbers) {
            if (i == bonusNum || bonusNum < 1 || bonusNum > 45) {
                throw IllegalArgumentException()
            }
        }
    }

    fun checkEachPlay(pickedNums: ArrayList<List<Int>>, bonusNum: Int, num: Int): List<Int> {
        var winningNums: List<Int> = numbers

        //몇개 일치하는지 저장하는 리스트 (rank[0]-> 첫번째 뽑은 숫자가 몇개나 맞는지 저장. 이때, 보너스도 맞으면 음수)
        var rank: MutableList<Int> = List<Int>(num, { 0 }).toMutableList()
        var count: Int = 0

        for (i in pickedNums) {
            rank[count] = checkSameNums(winningNums, i, bonusNum)
            count++
        }
        return rank
    }

    fun checkSameNums(winningNums: List<Int>, myNums: List<Int>, bonusNum: Int): Int {
        var result: Int = 0
        for (i in winningNums) {
            if (myNums.contains(i)) {
                result++
            }
        }
        //2등의 경우 음수로 바꿔서 보너스 숫자가 당첨 되었음을 표시 (3등-> 5 / 2등-> -5)
        if (result == 5 && myNums.contains(bonusNum)) {
            result *= -1
        }
        return result
    }

    //총 상금 계산
    fun getTotalPrize(rank: List<Int>): Int {
        var total: Int = 0
        for (i in rank) {
            total += getPrize(i)
        }

        return total
    }

    fun getPrize(i: Int): Int {
        when (i) {
            Prize.first.count -> return Prize.first.money
            Prize.second.count -> return Prize.second.money
            Prize.thrid.count -> return Prize.thrid.money
            Prize.fourth.count -> return Prize.fourth.money
            Prize.fifth.count -> return Prize.fifth.money
        }
        return 0
    }

    fun getMyRank(eachPlay: List<Int>): MutableList<Int> {
        val countRank: MutableList<Int> = List<Int>(5, { 0 }).toMutableList()
        for (i in eachPlay) {
            when (i) {
                3 -> countRank[0]++
                4 -> countRank[1]++
                5 -> countRank[2]++
                -5 -> countRank[3]++
                6 -> countRank[4]++
            }
        }
        return countRank
    }


}
