package lotto.constants

object LottoConstants {
  const val LOTTO_NUMBER_MIN = 1
  const val LOTTO_NUMBER_MAX = 45
  const val LOTTO_PRICE = 1000
  const val PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요."
  const val WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요."
  const val BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."
  const val ERROR_INVALID_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
  const val ERROR_INVALID_PURCHASE_AMOUNT = "구입 금액은 1,000원 단위로 입력해야 합니다."
  const val ERROR_DUPLICATE_NUMBER = "로또 번호는 중복될 수 없습니다."
  const val ERROR_LOTTO_SIZE = "로또 번호는 6개여야 합니다."
  const val ERROR_INVALID_BONUS_NUMBER = "보너스 번호는 1부터 45 사이의 숫자여야 합니다."
}