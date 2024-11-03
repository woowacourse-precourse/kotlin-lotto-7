package lotto.utils

enum class LottoMatchDescription(val description: String) {
    MATCH_3_DESCRIPTION("3개 일치 (5,000원)"),
    MATCH_4_DESCRIPTION("4개 일치 (50,000원)"),
    MATCH_5_DESCRIPTION("5개 일치 (1,500,000원)"),
    MATCH_5_BONUS_DESCRIPTION("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_6_DESCRIPTION("6개 일치 (2,000,000,000원)"),
}
enum class LottoMatchPrize(val prize: Int) {
    MATCH_3_PRIZE(5000),
    MATCH_4_PRIZE(50_000),
    MATCH_5_PRIZE(1_500_000),
    MATCH_5_BONUS_PRIZE(30_000_000),
    MATCH_6_PRIZE(2_000_000_000),
}

enum class PurchaseAmount(val value: Int) {
    LOTTO_PRICE(1000),
    MIN_PURCHASE_AMOUNT(1000),
    MAX_PURCHASE_AMOUNT(1_000_000)
}

enum class WinningNumbers(val value: Int) {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    WINNING_NUMBER_COUNT(6)
}