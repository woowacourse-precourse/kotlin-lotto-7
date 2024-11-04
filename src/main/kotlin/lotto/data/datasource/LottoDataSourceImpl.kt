package lotto.data.datasource

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.domain.enums.LottoSetting.LOTTO_MAX
import lotto.domain.enums.LottoSetting.LOTTO_MIN
import lotto.domain.enums.LottoSetting.LOTTO_SIZE
import java.util.TreeSet

fun generateLotto(): LottoDataSource = LottoDataSource {
    TreeSet(
        pickUniqueNumbersInRange(
            LOTTO_MIN.value(),
            LOTTO_MAX.value(),
            LOTTO_SIZE.value()
        )
    )
}