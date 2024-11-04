package lotto

enum class Result(val matchCount: Int, val reward: Int, val requiresBonus: Boolean = false) {
    FAILED(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000, requiresBonus = true),
    FIRST(6, 2000000000),
    ;

    companion object {
        fun from(matchCount: Int, hasBonus: Boolean): Result {
            return entries.find { result ->
                result.matchCount == matchCount && (result.requiresBonus == hasBonus || !result.requiresBonus)
            } ?: FAILED
        }
    }
}
