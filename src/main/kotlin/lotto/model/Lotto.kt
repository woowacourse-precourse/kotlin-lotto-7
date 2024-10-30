package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }
    //
    //생성된 로또와 사용자가 입력한 로또 번호를 비교하는 로직

}
