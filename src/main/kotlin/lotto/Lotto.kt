package lotto

class Lotto(private val numbers: List<Int>) {
    private var bonusNumber = 0
    private val CHECKBOUND = 3
    private val BONUSSCORE = 5
    private val LOTTOSIZE = 6
    private val BONUSINDEX = 3
    private val NOTBONUSINDEX = 2
    private val BONUS = 6
    private val NOTBONUS = 5

    private val output = Output()
    var checkList = MutableList(5) { 0 }
    var resultMoney = 0

    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    //나의 로또 번호와 보너스 번호를 받아 비교
    fun compareLotto(lottos: List<List<Int>>, bonusNumber: Int) {
        this.bonusNumber = bonusNumber
        for (lotto in lottos) {
            var resultScore = 0
            resultScore += compareLottos(lotto)
            val rank = checkedRank(resultScore, lotto)
            resultMoney += output.resultScore(rank)
        }
    }

    //로또 1장 당 맞춘 갯수를 리턴
    private fun compareLottos(lottoYou: List<Int>): Int {
        var score = 0
        for (i in 0 until LOTTOSIZE) {
            score += compareNumber(lottoYou[i])
        }
        return score
    }

    private fun compareNumber(numberYou: Int): Int {
        if (numbers.contains(numberYou)) {
            return 1
        }
        return 0
    }

    private fun checkedRank(score: Int, lotto: List<Int>): CorrectType {
        val checkIndex = score - CHECKBOUND
        if (score == BONUSSCORE) {
            return output.converterCorrectType(bonusFilter(lotto))
        }
        if (checkIndex >= 0) {
            checkList[checkIndex+winnerCheck(score)]++
        }
        return output.converterCorrectType(score)
    }

    private fun bonusFilter(lotto: List<Int>): Int {
        return if (lotto.contains(bonusNumber)) {
            checkList[BONUSINDEX]++
            BONUS
        } else {
            checkList[NOTBONUSINDEX]++
            NOTBONUS
        }
    }

    private fun winnerCheck(score: Int) : Int{
        if (score == 6) {
            return 1
        }
        return 0
    }
}
