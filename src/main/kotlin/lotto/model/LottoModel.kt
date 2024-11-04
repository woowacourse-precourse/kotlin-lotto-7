package lotto.model

class LottoModel(
  var generatedLottos: MutableList<List<Int>> = mutableListOf(),
  var winningNumbers: List<Int> = listOf(),
  var bonusNumber: Int? = null,
  var purchaseAmount: Int = 0,
  var lottoCount: Int = 0
)
