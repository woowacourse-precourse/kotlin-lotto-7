package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.MAX_NUMBER
import lotto.utils.Constants.MIN_NUMBER
import lotto.utils.Constants.LOTTO_NUMBER_COUNT
import lotto.utils.ErrorConstants

/**
 * 모델은 컨트롤러나 뷰에 의존하면 안된다.
 * 컨트롤러나 뷰의 코드가 있으면 안된다
 */

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { ErrorConstants.LOTTO_NUMBER_COUNT }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { ErrorConstants.LOTTO_NUMBER_RANGE }
        require(numbers.distinct().size == LOTTO_NUMBER_COUNT) { ErrorConstants.LOTTO_NUMBER_DUPLICATE }
    }


    fun ComparisonOfWinningNumbers(lotto: List<List<Int>>) {
        for (index in 0..lotto.size) {

        }
    }

    fun ComparisonOfBonusNumber(bonusNumber: Int) {

    }

    companion object {
        fun generate(): List<Int> = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT).sorted()
    }

    // TODO: 추가 기능 구현
    // 여기서 예외 처리를 하고, 당첨 번호와 맞는지 판단 해야할 듯?
    /**
     * 모델이 수행할 기능 목록
     *
     * 로또 번호와 당첨 번호 비교 -> 여기서 번호가 유효하면
     * enum 클래스와 비교해서 일치한 정보 전달 -> 위와 같이
     * 총 수익률 계산
     */
}
