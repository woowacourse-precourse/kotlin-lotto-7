package lotto

class WinningLotto(private val lotto: Lotto, private val bonusNumber: Int) {

    init {
        require(!lotto.lottoNumber.contains(bonusNumber)) { "[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다." }
    }
}