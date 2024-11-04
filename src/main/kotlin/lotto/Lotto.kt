package lotto
//테스트용 로또 리스트 생성 확인 클래스
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }
}