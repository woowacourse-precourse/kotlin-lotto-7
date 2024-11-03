package lotto

class User(private val purchasedLottoCount: Int) {
    val lottoList = mutableListOf<Lotto>() // 구매한 로또 리스트
    private var profit = 0
}