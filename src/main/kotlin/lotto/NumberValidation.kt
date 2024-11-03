package lotto

enum class NumberValidation(val errorMessage: String) {
    SIZE("[ERROR]입력된 숫자는 6개여야 합니다.") {
        override fun isValid(numbers: List<Int>) = numbers.size == 6
    },
    RANGE("[ERROR]입력된 숫자는 1부터 45 사이여야 합니다.") {
        override fun isValid(numbers: List<Int>) = numbers.all { it in 1..45 }
    },
    NO_DUPLICATES("[ERROR]입력된 숫자는 중복되지 않아야 합니다.") {
        override fun isValid(numbers: List<Int>) = numbers.distinct().size == numbers.size
    };

    abstract fun isValid(numbers: List<Int>): Boolean

    companion object {
        fun validate(numbers: List<Int>) {
            values().forEach { rule ->
                require(rule.isValid(numbers)) { rule.errorMessage }
            }
        }
    }
}