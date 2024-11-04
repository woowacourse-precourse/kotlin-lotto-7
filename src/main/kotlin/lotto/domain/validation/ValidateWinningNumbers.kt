package lotto.domain.validation

import lotto.domain.model.Lotto

fun validateWinningNumbers(winningNumbers: List<Int>) {
    // 로또 생성으로 당첨 번호 검증
    Lotto(winningNumbers)
}
