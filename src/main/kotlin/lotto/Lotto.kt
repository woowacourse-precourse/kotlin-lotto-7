package lotto

import lotto.view.InputView
import java.io.Serializable

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
}
