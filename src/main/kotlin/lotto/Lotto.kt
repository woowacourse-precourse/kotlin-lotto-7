package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6){"[ERROR] 중복된 숫자는 발행 불가합니다."}
        initLotto()
    }

    // TODO: 추가 기능 구현

    // [*] 초기화
    fun initLotto() {
        // 추후 필요 시 업데이트
    }

    // [*] Getter
    fun getLottoNumbers(): List<Int> {
        return this.numbers
    }

}
