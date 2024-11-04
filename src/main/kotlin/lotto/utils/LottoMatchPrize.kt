package lotto.utils

enum class LottoMatchPrize(val prize: Int) {
    MATCH_3_PRIZE(5000),
    MATCH_4_PRIZE(50_000),
    MATCH_5_PRIZE(1_500_000),
    MATCH_5_BONUS_PRIZE(30_000_000),
    MATCH_6_PRIZE(2_000_000_000)
}