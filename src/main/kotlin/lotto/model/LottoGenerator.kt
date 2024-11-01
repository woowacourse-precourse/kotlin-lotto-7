package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_NUMBER_COUNT
import lotto.utils.Constants.MAX_NUMBER
import lotto.utils.Constants.MIN_NUMBER

/**
 * 모델은 컨트롤러나 뷰에 의존하면 안된다.
 * 컨트롤러나 뷰의 코드가 있으면 안된다
 */

class LottoGenerator {

    fun generate(): List<Int>{
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT).sorted()
    }
}