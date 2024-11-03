package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.controller.dto.PurchasedLottoNumbersDto
import lotto.controller.dto.PurchasedLottoTicketsDto
import lotto.controller.dto.WinningProfitRateDto
import lotto.controller.dto.WinningStatisticsDto
import lotto.domain.enum.Prize

const val LOTTO_PRICE = 1000
const val WINNING_NUMBERS_SIZE = 6
const val LOTTO_NUMBER_MIN_VALUE = 1
const val LOTTO_NUMBER_MAX_VALUE = 45
val WINNING_RESULT_TEMPLATE = """
                    3개 일치 (5,000원) - %d개
                    4개 일치 (50,000원) - %d개
                    5개 일치 (1,500,000원) - %d개
                    5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                    6개 일치 (2,000,000,000원) - %d개
                    총 수익률은 %s%%입니다.
""".trimIndent()

class LottoGameView {
    fun getPurchaseAmount(): Int {
        println(LottoGameViewMessage.PROMPT_PURCHASE_AMOUNT.getMessage())
        return readInput { input ->
            validatePurchaseAmountInput(input)
            val amount = input.toInt()
            validatePurchaseAmount(amount)
            amount
        }
    }

    fun displayPurchasedLottoTickets(purchaseAmount: Int, purchasedLottoTickets: PurchasedLottoTicketsDto) {
        printWithBlankLines {
            println(
                String.format(
                    LottoGameViewMessage.PRINT_PURCHASE_AMOUNT.getMessage(),
                    purchaseAmount / LOTTO_PRICE
                )
            )
            purchasedLottoTickets.lottoTickets.forEach { ticket -> println(ticket) }
        }
    }

    fun getPurchasedLottoNumbers(): PurchasedLottoNumbersDto {
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)

        return PurchasedLottoNumbersDto(winningNumbers, bonusNumber)
    }

    fun displayLottoGameResults(results: WinningStatisticsDto, profitRate: WinningProfitRateDto) {
        printWithBlankLines {
            println("당첨 통계")
            println("---")

            val matchCounts = listOf(
                results.winningStatisticsDto[Prize.FIFTH],
                results.winningStatisticsDto[Prize.FOURTH],
                results.winningStatisticsDto[Prize.THIRD],
                results.winningStatisticsDto[Prize.SECOND],
                results.winningStatisticsDto[Prize.FIRST]
            )

            val formattedProfitRate = String.format("%.1f", profitRate.profit)
            val formattedResult =
                String.format(WINNING_RESULT_TEMPLATE, *matchCounts.toTypedArray(), formattedProfitRate)

            println(formattedResult)
        }
    }

    private fun getWinningNumbers(): List<Int> {
        println(LottoGameViewMessage.PROMPT_WINNING_NUMBERS.getMessage())
        return readInput { input ->
            validateWinningNumbersInput(input)
            val numbers = input.split(",").map { it.trim().toInt() }
            validateWinningNumbers(numbers)
            numbers
        }
    }

    private fun getBonusNumber(winningNumbers: List<Int>): Int {
        println(LottoGameViewMessage.PROMPT_BONUS_NUMBER.getMessage())
        return readInput { input ->
            validateEmptyInput(input)
            val number = input.toInt()
            validateBonusNumber(number, winningNumbers)
            number
        }
    }

    private fun <T> readInput(inputProcessor: (String) -> T): T {
        return try {
            inputProcessor(readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readInput(inputProcessor)
        }
    }

    private fun readLine(): String {
        return Console.readLine().trim()
    }

    private fun validateEmptyInput(input: String) {
        require(input.isNotBlank()) { LottoGameViewMessage.ERROR_EMPTY_INPUT.getErrorMessage() }
    }

    private fun validatePurchaseAmountInput(input: String) {
        validateEmptyInput(input)
        require(input.matches(Regex("\\d+"))) {
            throw IllegalArgumentException(LottoGameViewMessage.ERROR_INVALID_CHARACTERS.getErrorMessage())
        }
    }

    private fun validatePurchaseAmount(amount: Int) {
        require(amount % LOTTO_PRICE == 0) {
            throw IllegalArgumentException(LottoGameViewMessage.ERROR_PURCHASE_AMOUNT_UNIT.getErrorMessage())
        }
    }

    private fun validateWinningNumbersInput(input: String) {
        validateEmptyInput(input)

        require(!input.any { !it.isDigit() && it != ',' && !it.isWhitespace() }) {
            throw IllegalArgumentException(LottoGameViewMessage.ERROR_INVALID_CHARACTERS.getErrorMessage())
        }

        require(!input.endsWith(",") && !input.endsWith(" ")) {
            throw IllegalArgumentException(LottoGameViewMessage.ERROR_TRAILING_COMMA.getErrorMessage())
        }
    }

    private fun validateWinningNumbers(numbers: List<Int>) {
        require(numbers.size == WINNING_NUMBERS_SIZE) {
            throw IllegalArgumentException(LottoGameViewMessage.ERROR_WINNING_NUMBERS_SIZE.getErrorMessage())
        }
        require(numbers.all { it in LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE }) {
            throw IllegalArgumentException(LottoGameViewMessage.ERROR_WINNING_NUMBERS_RANGE.getErrorMessage())
        }
    }

    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        require(bonusNumber in LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE) {
            throw IllegalArgumentException(LottoGameViewMessage.ERROR_BONUS_NUMBER_RANGE.getErrorMessage())
        }
        require(bonusNumber !in winningNumbers) {
            throw IllegalArgumentException(LottoGameViewMessage.ERROR_DUPLICATED_LOTTO_NUMBER.getErrorMessage())
        }
    }

    private fun printWithBlankLines(action: () -> Unit) {
        println()
        action()
        println()
    }
}
