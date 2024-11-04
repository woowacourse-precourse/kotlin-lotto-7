package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == numbers.toSet().size){"[ERROR] 로또 번호는 중복이 없어야 합니다."}
        numbers.forEach{
            require(it>0 && it<46){"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."}
        }
        //require(numbers.isNotEmpty()){"[ERROR] 로또 번호는 공백이 아니여야 합니다."}
    }

}
