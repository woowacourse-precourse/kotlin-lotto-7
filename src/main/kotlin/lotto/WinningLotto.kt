package lotto

class WinningLotto(private val lotto: Lotto, private val bonusNumber: Int) {

    init {
        require(!lotto.lottoNumber.contains(bonusNumber)) {}
    }
}