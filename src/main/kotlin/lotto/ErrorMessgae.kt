package lotto

enum class ErrorMessage(private val message: String) {
    NUMBER_UNIT("로또 한장은 1,000원 입니다. 다시 입력해주세요"),
    NUMBER_INTEGER("정수만 입력 가능합니다"),
    NUMBER_NATURAL("입력이 자연수가 아닙니다."),
    NUMBER_RANGE("1~45사이의 수가 아닙니다"),
    NUMBER_DISTINCT("이미 입력한 번호 입니다."),
    NUMBER_BONUS("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    NUMBER_NULL("입력값이 존재하지 않습니다."),
    NUMBER_SIZE("당첨 번호의 개수는 6개입니다.");

    fun getMessage(): String = "[ERROR] $message"
}