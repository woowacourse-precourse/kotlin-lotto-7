package lotto.domain.enums

enum class Exception(private val msg: String) {
    EMPTY_INPUT("빈 값이 입력 되었어요."),
    INVALID_INPUT("정수만 입력해주세요."),
    INVALID_FORMAT("숫자와 구분자 쉼표(,)만 입력해주세요."),
    INVALID_UNIT("구입 금액은 천원 단위로만 입력해주세요."),
    EXCEED_MAX_INT("입력한 값이 범위를 벗어났어요."),
    EXCEED_INPUT("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_SIZE("당첨 번호는 6개를 입력해주세요."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_DUPLICATED("당첨 번호는 중복될 수 없어요.");

    override fun toString(): String = "$ERROR $msg"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}