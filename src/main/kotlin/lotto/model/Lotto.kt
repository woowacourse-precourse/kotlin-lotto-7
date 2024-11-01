package lotto.model


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
        println(count)
        if (count == 6) LottoResult.first += 1
        else if (count == 5 && lotto.contains(bonusNum)) LottoResult.second += 1
        else if (count == 5) LottoResult.third += 1
        else if (count == 4) LottoResult.fourth += 1
        else if (count == 3) LottoResult.fifth += 1

    }

    fun recordPrice(money: Int) {
        var total = 0f
        total = LottoResult.first * 2000000000f + LottoResult.second * 30000000f + LottoResult.third*1500000f+LottoResult.fourth*50000f+LottoResult.fifth*5000f
        LottoResult.priceRatio = (total/money*100f)
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