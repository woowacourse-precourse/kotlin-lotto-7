package lotto.model

class Stat(
    private val rank: Rank,
    private var count: Int = 0
) {
    fun getRank() = rank

    fun getCount() = count

    fun increaseCount() {
        count++
    }
}
