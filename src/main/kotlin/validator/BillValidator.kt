package validator

class BillValidator {
    fun billCheck(billInput: Int): Boolean {
        var error = false
        try {
            isBillEnough(billInput)
            isBillDivided(billInput)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            error = true
        }
        return error
    }

    private fun isBillEnough(billNumber: Int) {
        if (billNumber < 1000) {
            val errorMessage = ErrorMessage.BILLS_NOT_ENOUGH
            throw IllegalArgumentException(errorMessage.getMessage())
        }
    }

    private fun isBillDivided(billNumber: Int) {
        if (billNumber % 1000 != 0) {
            val errorMessage = ErrorMessage.BILLS_NOT_DIVIDED
            throw IllegalArgumentException(errorMessage.getMessage())
        }
    }
}