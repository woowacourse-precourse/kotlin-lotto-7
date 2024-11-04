package validator

class PurchaseAmountValidator(
    private val numericValidator: StringGenerator = DivisibilityValidator(),
    private val stringValidator: StringGenerator = StringValidator()
) : StringGenerator {
    override fun validate(value: String) {
        numericValidator.validate(value)
        stringValidator.validate(value)
    }
}