package lotto.utils

enum class LottoMatchDescription(val description: String) {
    MATCH_3_DESCRIPTION("3개 일치 (5,000원)"),
    MATCH_4_DESCRIPTION("4개 일치 (50,000원)"),
    MATCH_5_DESCRIPTION("5개 일치 (1,500,000원)"),
    MATCH_5_BONUS_DESCRIPTION("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_6_DESCRIPTION("6개 일치 (2,000,000,000원)")
}