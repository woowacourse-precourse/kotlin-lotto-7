package lotto

class User(val purchasedLottoCount: Int) {
    val lottoList = mutableListOf<Lotto>() // 구매한 로또 리스트
    var profit = 0 // 당첨금

    init {
        addLottos()
    }

    fun addLottos(){
        val newLottos = LotteryMachine.generateLottos(purchasedLottoCount)
        lottoList.addAll(newLottos)
    }

    fun addProfit(amount: Int) {
        profit += amount
    }
}