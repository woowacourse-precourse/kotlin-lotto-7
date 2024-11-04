package lotto.constant

object Error {
    const val NOT_NUMBER = "[ERROR] 숫자를 입력해주세요. %s은 숫자가 아닙니다."
    const val UNIT_OF_PRICE = "[ERROR] %d원 단위로 입력해주세요."
    const val LOTTO_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val LOTTO_SIZE = "[ERROR] 당첨 번호는 6개의 숫자로 입력해주세요."
    const val LOTTO_DUPLICATE = "[ERROR] 번호는 중복되면 안됩니다."
}