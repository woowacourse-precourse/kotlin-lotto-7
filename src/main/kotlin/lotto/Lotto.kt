package lotto

enum class Price {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    LOSE
}

class ErrorMessage () {
    companion object {
        val notValid = "[ERROR] 올바른 값을 입력해주세요.\n"
        val notPerfectlyDivided = "[ERROR] 1000원 단위로 입력해주세요.\n"
        val notSixNumbers = "[ERROR] 6개의 숫자를 입력해주세요\n"
        val notInRange = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n"
        val isDuplex = "[ERROR] 로또 번호는 중복될 수 없습니다. \n"
    }
}

fun getPurchaseAmount():Int {
    print("구입금액을 입력해 주세요.\n")
    var purchaseInput = camp.nextstep.edu.missionutils.Console.readLine()
    var purchaseAmount = purchaseInput.toInt() / 1000

    try {
        purchaseInput.toInt() / 1000
    } catch (exception:NumberFormatException) {
        throw IllegalArgumentException(ErrorMessage.notValid)
    }
    if (purchaseInput.toInt() % 1000 != 0) {
        throw IllegalArgumentException(ErrorMessage.notPerfectlyDivided)
    }

    return purchaseAmount
}

fun getPickedNumbers():List<String> {
    print("당첨 번호를 입력해 주세요.\n")
    var pickedNumbers = camp.nextstep.edu.missionutils.Console.readLine().split(',')

    if (pickedNumbers.size != 6) {
        throw IllegalArgumentException(ErrorMessage.notSixNumbers)
    }

    try {
        pickedNumbers.all { it.toInt() in 1..45 } || throw IllegalArgumentException(ErrorMessage.notInRange)
    } catch (err:NumberFormatException) {
        throw IllegalArgumentException(ErrorMessage.notValid)
    }

    if (pickedNumbers.toHashSet().size != 6) {
        throw IllegalArgumentException(ErrorMessage.isDuplex)
    }
    return pickedNumbers

}

fun getBonusNumber():Int {
    print("보너스 번호를 입력해 주세요.\n")
    var bonusNumber = camp.nextstep.edu.missionutils.Console.readLine()

    try {
        bonusNumber.toInt()
    } catch (exception:NumberFormatException) {
        print(ErrorMessage.notValid)
    }

    if (bonusNumber.toInt() !in 1..45) {
        throw IllegalArgumentException(ErrorMessage.notInRange)
    }

    if (bonusNumber in pickedNumbers) {
        throw IllegalArgumentException(ErrorMessage.isDuplex)
    }
    return bonusNumber.toInt()
}
fun getLotto():MutableList<Int> {
    val LOTTO_COUNT:Int = 6
    val STRAT_LOTTO_NUM:Int = 1
    val END_LOTTO_NUM:Int = 45
    var lottoNotDuplex:HashSet<Int> = hashSetOf()
    var lottoTicket:MutableList<Int> = mutableListOf()

    while (lottoNotDuplex.size != 6) {
        lottoTicket = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(STRAT_LOTTO_NUM, END_LOTTO_NUM, LOTTO_COUNT)
        lottoNotDuplex = lottoTicket.toHashSet()
    }
    lottoTicket.sort()
    return lottoTicket
}



class Lotto(private val numbers: List<Int>) {
    init {
        var numbersNotDuplex:HashSet<Int> = numbers.toHashSet()

        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbersNotDuplex.size == 6) {"[ERROR] 로또 번호는 중복될 수 없습니다" }
        numbers.all { it in 1..45 } || throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }

    fun determineWith(pickedNumbers:MutableList<Int>, bonusNumber:Int):Price {
        var winningCount = numbers.count { it in pickedNumbers }
        if (winningCount == 3) {
            return Price.FIFTH
        }
        if (winningCount == 4) {
            return Price.FOURTH
        }
        if (winningCount == 5) {
            pickedNumbers.add(bonusNumber)
            winningCount = numbers.count { it in pickedNumbers }
            if (winningCount == 6) {
                return Price.SECOND
            }
            return Price.THIRD
        }
        if (winningCount == 6) {
            return Price.FIRST
        }
        return Price.LOSE
    }

    // TODO: 추가 기능 구현

}
