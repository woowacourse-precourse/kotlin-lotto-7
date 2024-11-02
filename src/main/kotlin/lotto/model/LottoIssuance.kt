package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.view.OutputView

class LottoIssuance(private val numberOfIssuance: Int) {

    var lottoList: MutableList<List<Int>> = mutableListOf()

    init {
        issuance()
    }
    fun getLotto(): List<Int> {
        var tmp = Randoms.pickUniqueNumbersInRange(1, 45, 6).toList()
        return tmp.sorted()
    }

    fun issuance() {
        for (i in 1..numberOfIssuance) {
            lottoList.add(getLotto())
        }
        OutputView.printLotto(lottoList)
    }
}