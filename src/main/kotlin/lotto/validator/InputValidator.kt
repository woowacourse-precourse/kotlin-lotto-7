package lotto.validator

const val MONEY_REGEX = "^\\d{1,3}(,\\d{3})*?$|^\\d+$"
const val AMOUNT_UNIT = 1000

class InputValidator {

    fun isValidMoney(input : String) : Boolean{
        val regex = Regex(MONEY_REGEX)
        val money = input.replace(",","").toIntOrNull()

        if(input == ""){
            ValidatorMessage.INPUT_MONEY.display()
            return false
        }
        else if(!regex.matches(input)){
            ValidatorMessage.INPUT_MONEY.display()
            println("asdf")
            return false
        }
        else if(money == null){
            ValidatorMessage.INPUT_MONEY.display()
            return false
        }
        else if (money% AMOUNT_UNIT!=0 || money<=0){
            ValidatorMessage.INPUT_MONEY.display()
            return false
        }

        return true


    }
}

enum class ValidatorMessage(val message: String){
    INPUT_MONEY("잘못된 입력입니다. 다시 입력해 주세요.");

    fun display(){
        println("[Error] ${message}")
    }
}