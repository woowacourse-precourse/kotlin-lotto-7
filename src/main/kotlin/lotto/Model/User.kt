package lotto.Model

import lotto.Controller.LotteryMachine
import lotto.Model.Lotto

class User(val purchasedLottoCount: Int) {
    val lottoList = mutableListOf<Lotto>() // 구매한 로또 리스트
    var profit = 0 // 당첨금 총액

    init {
        addLottos()
    }

    // 구매 수량만큼 LotteryMachine에서 로또를 발행 후 User의 lottoList에 저장
    fun addLottos(){
        val newLottos = LotteryMachine.generateLottos(purchasedLottoCount)
        lottoList.addAll(newLottos)
    }

    fun addProfit(amount: Int) {
        profit += amount
    }
}