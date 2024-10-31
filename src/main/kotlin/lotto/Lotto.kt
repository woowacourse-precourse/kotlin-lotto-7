package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        val nameCounts = numbers.groupingBy { it }.eachCount()
        val minNum = numbers.minOf { it }
        val maxNum = numbers.maxOf { it }
        require(nameCounts.maxOf { it.value } == 1) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
        require(minNum >= 1 && maxNum <= 45) { "[ERROR] 로또 번호는 1부터 45 사이의 값이어야 합니다." }
    }

}
