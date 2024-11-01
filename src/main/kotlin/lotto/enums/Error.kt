package lotto.enums

import lotto.constants.ERROR

enum class Error(val message: String) {
    INPUT_EMPTY(ERROR.format("값을 입력해 주세요!")),
    NOT_SPACE_AFTER_EMPTY(ERROR.format("쉼표(,) 뒤에 값이 입력되지 않았습니다.")),
    NOT_NEGATIVE_NUMBER(ERROR.format("음수를 입력할 수 없습니다.")),
    NOT_MULTIPLE_OF_1000(ERROR.format("1000원 단위로 입려해주십시오.")),
    NOT_0_BETWEEN_45(ERROR.format("0~45 숫자를 입력해주십시오.")),
    ONLY_ONE_BONUS_NUMBER(ERROR.format("보너스 번호는 한숫자만 입력 가능합니다")),
    ONLY_NUMBER(ERROR.format("숫자만 입력할 수 있습니다."))
}
