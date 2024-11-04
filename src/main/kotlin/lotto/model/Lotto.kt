package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoGame.WINNING_BALL_COUNT) { LottoGame.ERROR_REQUIRE_LOTTO_SIZE_MESSAGE }
        require(numbers.size == numbers.distinct().size) { LottoGame.ERROR_REQUIRE_UNIQUE_NUMBER_MESSAGE }
        require(numbers.all { it in LottoGame.MIN_BALL_NUMBER..LottoGame.MAX_BALL_NUMBER }) { LottoGame.ERROR_REQUIRE_LOTTO_NUMBER_RANGE_MESSAGE }
    }

    fun sort(): List<Int> {
        return numbers.sorted()
    }
}
