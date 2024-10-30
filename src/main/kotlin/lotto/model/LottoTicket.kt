package lotto.model

import lotto.Lotto

class LottoTicket {
    private var _numberOfPurchase = 0

    var numberOfPurchase: Int
        get() = _numberOfPurchase
        set(value) {
            _numberOfPurchase = value
        }

    private val _userLottoNumbers = mutableListOf<Lotto>()

    val userLottoNumbers: List<Lotto>
        get() = _userLottoNumbers
}