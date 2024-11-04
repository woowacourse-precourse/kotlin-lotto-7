package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto
import lotto.domain.LottoNumberValidator
import lotto.domain.PurchaseAmount

object InputView {
    fun inputPurchaseMoney(): PurchaseAmount {
        println(INPUT_PURCHASE_MONEY_MESSAGE)
        return try {
            val money = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException(
                ERROR_INVALID_INPUT_MESSAGE
            )
            PurchaseAmount(money)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputPurchaseMoney()
        }
    }

    fun inputLottoNumbers(): Lotto {
        println(INPUT_LOTTO_NUMBER_MESSAGE)
        return try {
            val winningNumbers = Console.readLine().split(NUMBER_DELIMITER).map {
                it.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_INPUT_MESSAGE)
            }
            Lotto(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputLottoNumbers()
        }
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        return try {
            val bonusNumber = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException(
                ERROR_INVALID_INPUT_MESSAGE
            )
            require(!winningNumbers.contains(bonusNumber)) { ERROR_DUPLICATE_NUMBER_MESSAGE }
            LottoNumberValidator.validate(bonusNumber)
            bonusNumber
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputBonusNumber(winningNumbers)
        }
    }

    private const val INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요."
    private const val INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
    private const val ERROR_INVALID_INPUT_MESSAGE = "[ERROR] 올바른 숫자를 입력해야 합니다."
    private const val ERROR_DUPLICATE_NUMBER_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다."

    private const val NUMBER_DELIMITER = ','
}