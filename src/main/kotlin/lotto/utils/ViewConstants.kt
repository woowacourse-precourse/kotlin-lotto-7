package lotto.utils

enum class InputUserGuide(private val transmission: String) {
    MONEY("구입금액을 입력해 주세요."),
    NUMBER("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요.");

    override fun toString(): String = transmission
}

enum class OuputString(private val transmission: String) {
    TRY_COUNT("개를 구매했습니다."),
    RESULT("당첨 통계"),
    BAR("---"),
    MATCHE_3("3개 일치 (5,000원) - "),
    MATCHE_4("4개 일치 (50,000원) - "),
    MATCHE_5("5개 일치 (1,500,000원) - "),
    MATCHE_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - " ),
    MATCHE_6("6개 일치 (2,000,000,000원) - "),
    MATCHE_END("개"),
    REVENUE("총 수익률은 "),
    REVENUE_END("%입니다.");
    override fun toString(): String = transmission
}