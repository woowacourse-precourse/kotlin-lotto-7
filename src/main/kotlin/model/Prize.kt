package model

enum class Prize(val matchCount: Int, val prize: Int, var winningCount: Int) {
    FIFTH(3, 5000, 0),
    FOURTH(4, 50000, 0),
    THIRD(5, 1500000, 0),
    SECOND(5, 30000000, 0),
    FIRST(6, 2000000000, 0)
    ;

    fun plusCount() {
        this.winningCount += 1
    }

}
