package view

class ErrorMessage {
    companion object {
        const val EMPTY_PURCHASED_NUMBER = "[ERROR] 구입 금액을 입력해 주세요."
        const val EMPTY_BONUS_NUMBER = "[ERROR] 숫자를 입력해 주세요."
        const val OUT_OF_INT_RANGE = "[ERROR] Int 최대값(2,147,483,647)을 초과했습니다."
        const val NOT_NUMBERS = "[ERROR] 숫자만 입력 가능합니다."
        const val NOT_DIVIDE_THOUSAND = "[ERROR] 천원 단위로 입력해 주세요."
        const val OUT_OF_LOTTO_NUMBER_RANGE = "[ERROR] 로또번호 범위를 벗어났습니다."
        const val NOT_INPUT_SIX_NUMBER = "[ERROR] 6개의 번호가 아닙니다."
        const val DUPLICATED_NUMBERS = "[ERROR] 당첨번호를 입력했습니다."
    }
}