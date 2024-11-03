package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.lotto.Lotto
import view.InputView
import view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    fun run(){

    }

    private fun createLottoNumbers(purchasedAmount : Int): List<Lotto>{
        return List(purchasedAmount) { Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)) }
    }
}