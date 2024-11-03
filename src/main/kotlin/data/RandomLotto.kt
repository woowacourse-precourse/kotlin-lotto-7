package data

class RandomLotto(private val numbers: List<List<Int>>) {

    val read: List<List<Int>>
        get() = numbers

    override fun toString(): String {
        return numbers.joinToString(", ") { it.toString() }
    }
}
