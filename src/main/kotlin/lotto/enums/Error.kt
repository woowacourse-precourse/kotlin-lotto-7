package lotto.enums

import lotto.constants.ERROR

enum class Error(val message: String) {
    INPUT_EMPTY(ERROR.format("값을 입력해 주세요!")),
    NOT_MULTIPLE_OF_1000(ERROR.format("1000원 단위로 입려해주십시오.")),
    NOT_1_BETWEEN_45(ERROR.format("1~45 숫자를 입력해주십시오.")),
    ONLY_ONE_BONUS_NUMBER(ERROR.format("보너스 번호는 한숫자만 입력 가능합니다.")),
    ONLY_NUMBER(ERROR.format("숫자만 입력할 수 있습니다.")),
    MIN_SIX(ERROR.format("6개의 숫자를 입력하셔야 합니다.")),
    ONLY_COMMA(ERROR.format("구분자는 쉼표(,)를 사용해 주십시오."))
}
