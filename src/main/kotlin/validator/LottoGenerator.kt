package validator

class LottoGenerator : NumbersValidator {

    override fun validate(value: List<Int>) {
        require(value.distinct().size == value.size) {
            GENERATOR_ERROR_FORMAT.format(value)
        }
    }

    companion object {
         const val GENERATOR_ERROR_FORMAT = "로또 번호는 중복될 수 없습니다."
    }
}