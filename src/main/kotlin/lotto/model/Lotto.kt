package lotto.model

import lotto.constant.WinningPrize


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun get(): List<Int> {
        return numbers
    }

    fun getResult(money: Int, bonusNum: Int, purchasedLotto: List<List<Int>>) {

        purchasedLotto.forEach {
            recordRank(it, bonusNum)
        }
        recordPrice(money)
    }

    fun recordRank(lotto: List<Int>, bonusNum: Int) {
        val count = lotto.intersect(numbers).size
        if (count == 6) LottoResult.first++
        else if (count == 5 && lotto.contains(bonusNum)) LottoResult.second++
        else if (count == 5) LottoResult.third++
        else if (count == 4) LottoResult.fourth++
        else if (count == 3) LottoResult.fifth++

    }

    fun recordPrice(money: Int) {

        val total = (LottoResult.first * WinningPrize.FIRST.prize) +
                (LottoResult.second * WinningPrize.SECOND.prize) +
                (LottoResult.third * WinningPrize.THIRD.prize) +
                (LottoResult.fourth * WinningPrize.FOURTH.prize) +
                (LottoResult.fifth * WinningPrize.FIFTH.prize)

        LottoResult.priceRatio = (total / money * 100f)
    }
}

object LottoResult {
    var first: Int = 0
    var second: Int = 0
    var third: Int = 0
    var fourth: Int = 0
    var fifth: Int = 0
    var priceRatio: Float = 0f
}