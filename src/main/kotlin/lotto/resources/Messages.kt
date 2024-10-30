package template.resources

object Messages {
    // 안내 메시지
    const val INFO_INPUT_MONEY = "구입금액을 입력해 주세요."
    const val INFO_BUY_AMOUNT = "%s개를 구매했습니다."
    const val INFO_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
    const val INFO_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

    const val INFO_WINNING_STATISTICS = """
당첨 통계
---
3개 일치 (5,000원) - %s개
4개 일치 (50,000원) - %s개
5개 일치 (1,500,000원) - %s개
5개 일치, 보너스 볼 일치 (30,000,000원) - %s개
6개 일치 (2,000,000,000원) - %s개
"""

    // 에러 메시지
    const val ERROR = "[ERROR] %s"

    const val DUPLICATE_LOTTO_NUMBER = "로또 번호에 중복값이 존재합니다"
    const val ERROR_EMPTY_INPUT = "입력값이 비어있습니다."
    const val ERROR_DUPLICATE_NAME = "컬렉션에 중복값이 존재합니다"

    const val ERROR_OVERSIZE_TRY_COUNT = "너무 크거나 잘못된 입력입니다."
    const val ERROR_NOT_POSITIVE = "양의 정수만 입력 가능합니다."
}
