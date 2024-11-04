package lotto.model

class LottoTicket {
    private var _numberOfPurchase = 0

    var numberOfPurchase: Int
        get() = _numberOfPurchase
        set(value) {
            _numberOfPurchase = value
        }

    private var _userLottoNumbers = mutableListOf<Lotto>()

    var userLottoNumbers: List<Lotto>
        get() = _userLottoNumbers
        set(numbers) {
            _userLottoNumbers.addAll(numbers)
        }
}