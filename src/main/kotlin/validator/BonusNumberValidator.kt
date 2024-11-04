package validator

class BonusNumberValidator(
    private val randomLottoNum: List<Int>,
    private val stringValidator: StringGenerator = StringValidator(),
    private val rangeValidator: NumbersValidator = RangeValidator()
) : StringGenerator {
    override fun validate(value: String) {
        stringValidator.validate(value)
        rangeValidator.validate(listOf(value.toInt()))
        validateForDuplicate(value)

    }

    private fun validateForDuplicate(value: String) {
        require(randomLottoNum.contains(value.toInt()).not()) {
            BONUS_NUMBER_ERROR_FORMAT.format(value, randomLottoNum)
        }
    }

    companion object {
        private const val BONUS_NUMBER_ERROR_FORMAT = "보너스는 뽑은 값과 중복될 수 없습니다."
    }

}