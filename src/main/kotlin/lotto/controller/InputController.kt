package lotto.controller

import lotto.constants.ErrorConstant
import lotto.repository.Repository
import lotto.view.InputView

class InputController(
    private val repo: Repository
) {
    private val inputView = InputView()

    fun inputPurchaseAmount() {
        while (true) {
            val input = inputView.purchaseAmountInput()
            try {
                val purchaseAmount = input.toInt()
                repo.setPurchaseAmount(purchaseAmount)
                break
            } catch (e: NumberFormatException) {
                println(ErrorConstant.ERROR_PURCHASE_AMOUNT_IS_NOT_INTEGER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputWinningNumber() {
        while (true) {
            val input = inputView.winningNumberInput()
            try {
                val winningNumber = input
                    .split(",")
                    .map{ it.toInt() }
                    .toList()
                repo.setWinningNumber(winningNumber)
                break
            } catch (e: NumberFormatException) {
                println(ErrorConstant.ERROR_WINNING_NUMBER_INVALID_CHARACTER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputBonusNumber() {
        while (true) {
            val input = inputView.bonusNumberInput()
            try {
                val bonusNumber = input.toInt()
                repo.setBonusNumber(bonusNumber)
                break
            } catch (e: NumberFormatException) {
                println(ErrorConstant.ERROR_BONUS_NUMBER_INVALID_CHARACTER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}