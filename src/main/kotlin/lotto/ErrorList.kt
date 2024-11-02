package lotto

class ErrorList {
    companion object {
        const val BLANK = "[ERROR] 구입 금액을 입력해 주세요."
        const val NOT_NUMBERS = "[ERROR] 숫자만 입력 가능합니다."
        const val NOT_DIVIDE_THOUSAND = "[ERROR] 천원 단위로 입력해 주세요."
        const val NOT_LOTTO_NUMBER_RANGE = "[ERROR] 로또번호 범위를 벗어났습니다."
        const val NOT_INPUT_SIX_NUMBER = "[ERROR] 6개의 번호가 아닙니다."
        const val DUPLICATED_NUMBERS = "[ERROR] 같은 숫자를 입력했습니다."
    }
}