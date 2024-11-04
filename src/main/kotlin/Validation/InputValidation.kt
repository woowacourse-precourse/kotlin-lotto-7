package Validation

class InputValidation {
    fun isValidUnit(money: Int): Boolean {
        return money % 1_000 == 0
    }
}