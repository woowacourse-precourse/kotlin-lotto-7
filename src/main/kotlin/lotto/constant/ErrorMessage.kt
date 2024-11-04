package lotto.constant

enum class ErrorMessage(val msg: String) {
    BASE("[ERROR]"),

    WRONG_MONEY("잘못된 금액을 입력하였습니다."),
    WRONG_WINNING_NUMBER("잘못된 당첨번호를 입력하였습니다."),
    WRONG_BONUS_NUMBER("잘못된 보너스 번호를 입력하였습니다."),

    THOUSAND_UNIT("1000원 단위의 금액을 입력하셔야 합니다."),
    NOT_ZERO("1000원 이상의 금액을 입력하셔야 합니다."),
    WRONG_RANGE("로또 번호는 1~45 사이의 수를 입력해야 합니다."),
    INPUT_SIX_NUMBER("로또 번호는 6개의 숫자를 입력하셔야 합니다."),
    DUPLICATE_NUMBER("중복되지 않은 숫자를 입력해야 합니다."),
    NOT_NUMBER("문자를 제외한 숫자만을 입력해주셔야 합니다."),
    NOT_NUMBER_EXCEPT_COMMA(",를 제외한 다른 문자를 입력하시면 안됩니다."),
}