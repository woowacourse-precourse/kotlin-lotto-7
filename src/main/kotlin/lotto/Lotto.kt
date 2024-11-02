package lotto

import lotto.view.InputView
import java.io.Serializable
import kotlin.math.round

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun compare(lotto: List<Int>): Int{
        return lotto.toSet().intersect(numbers.toSet()).count()
    }

    fun compLottoList(lottoList: MutableList<List<Int>>, bonusNum: Int): IntArray {
        var result = IntArray(5, {0})
        for (lotto in lottoList) {
            val matchNum = compare(lotto)
            if (matchNum <= 2) continue
            if (matchNum == 5 && lotto.contains(bonusNum)) {
                result[4]++
                continue
            }
            result[matchNum-3]++
        }
        return result
    }

    fun calcutateYields(matchNum: IntArray, money: Int): Double {
        var profit: Double
        ((matchNum[0] * 5000) + (matchNum[1] * 50000) + (matchNum[2] * 1500000) + (matchNum[4] * 30000000) + (matchNum[3] * 2000000000.0)).also { profit = it }
        var yield: Double = (profit / (money * 1000)) * 100
        yield = round(yield*10)/10
        return yield
    }
}
