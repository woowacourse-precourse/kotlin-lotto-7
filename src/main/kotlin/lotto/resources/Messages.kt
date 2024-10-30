package lotto.resources

import lotto.domain.InputValidator

enum class Messages(private val message: String) {
    INFO_INPUT_MONEY("구입금액을 입력해 주세요."),
    INFO_BUY_AMOUNT("%d개를 구매했습니다."),
    INFO_INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INFO_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    INFO_WINNING_STATISTICS(
        """
        당첨 통계
        ---
        3개 일치 (5,000원) - %d개
        4개 일치 (50,000원) - %d개
        5개 일치 (1,500,000원) - %d개
        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
        6개 일치 (2,000,000,000원) - %d개
        """.trimIndent()
    ),
    INFO_RETURN_RATE("총 수익률은 %s입니다."),

    ERROR("[ERROR] %s"),
    DUPLICATE_LOTTO_NUMBER("로또 번호에 중복값이 존재합니다"),
    INVALID_LOTTO_RANGE(
        "로또의 각 번호는 ${InputValidator.LOTTO_START_VALUE}이상 ${InputValidator.LOTTO_END_VALUE}이하로 입력해 주세요"
    ),
    NOT_SIX_NUMBER("입력값이 ${InputValidator.LOTTO_LENGTH}자리가 아닙니다."),
    EMPTY_INPUT("입력값이 비어있습니다."),
    NOT_NUMBER("올바른 숫자 형식이 아니거나 너무 큰 값을 입력하셨습니다."),
    NOT_DIVIDED_BY_UNIT("${InputValidator.MONEY_UNIT}으로 나누어 떨어지는 양의 정수를 입력해주세요."),
    INVALID_ERROR("알 수 없는 오류가 발생했습니다.");

    fun message(): String = message
    fun errorMessage(): String = ERROR.formattedMessage(message)
    fun formattedMessage(vararg args: Any): String = String.format(message, *args)
}
