package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        NumberValidation.validate(numbers)
         }

    override fun toString(): String {
        return numbers.toString()
    }
}
