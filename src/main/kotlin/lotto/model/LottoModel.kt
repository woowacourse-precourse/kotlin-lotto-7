package lotto.model

data class LottoModel(
  val generatedLottos: MutableList<List<Int>> = mutableListOf(),
  var winningNumbers: List<Int>? = null,
  var bonusNumber: Int? = null
)
