package lotto.util

object Error {
    const val IS_NUMBER = "[ERROR] 입력은 숫자여야 합니다."
    const val GIVE_ME_MONEY = "[ERROR] 돈은 주셔야 합니다."
    const val IS_THOUSAND_UNITS = "[ERROR] 돈은 천 단위 숫자여야 합니다."
    const val LOTTERY_FORMAT = "[ERROR] 로또 입력 형식이 맞지 않습니다."
    const val LOTTERY_RANGE = "[ERROR] 로또 번호의 범위는 1 ~ 45 입니다."
    const val DUPLICATION_WITH_WINNING = "[ERROR] 로또 번호와 중복됩니다."
    const val SIX_NUMBER = "[ERROR] 로또 번호는 6개여야 합니다."
    const val WINNING_DUPLICATION = "[ERROR] 로또 번호는 중복이 없여야 합니다."
}