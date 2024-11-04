package lotto.View

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.LottoResult

class OutputView {

    fun outputLottoNum(amount: Int): MutableList<List<Int>> {

        println("${amount}개를 구매했습니다.")

        var outputLotto = mutableListOf<List<Int>>()

        for (num in 0 until amount) {
            outputLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        }

        outputLotto.forEach { lottoNumbers ->
            println(lottoNumbers)
        }

        return outputLotto
    }
}