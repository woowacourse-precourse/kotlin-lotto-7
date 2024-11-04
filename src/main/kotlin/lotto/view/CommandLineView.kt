package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.domain.Lotto
import lotto.domain.LottoResult
import java.text.NumberFormat
import java.util.*

class CommandLineView(private val viewModel: ViewModel = ViewModel()) : View {
    override fun buyLottos() {
        println("구입금액을 입력해 주세요.")
        var input = readLine()
        while (!input.isValidPurchaseAmount) {
            if (input.toLongOrNull() == null) {
                println("[ERROR] 숫자를 입력해주세요.")
                input = readLine()
                continue
            }
            if (input.toLong() < Lotto.PRICE || input.toLong() % Lotto.PRICE != 0L) {
                println("[ERROR] 로또 금액(${Lotto.PRICE})의 배수로 입력해주세요.")
                input = readLine()
                continue
            }
        }
        viewModel.buyLottos(input.toLong())
    }

    private val String.isValidPurchaseAmount get() = toLongOrNull() != null && toLong() >= Lotto.PRICE && toLong() % Lotto.PRICE == 0L

    override fun displayWinningLottos() {
        println("${viewModel.winningLottos?.count()}개를 구매했습니다.")
        println(viewModel.winningLottos?.joinToString(separator = "\n") { winningLotto ->
            winningLotto.getNumbers().joinToString(prefix = "[", postfix = "]")
        })
    }

    override fun readUserLottoNumbers() {
        println("당첨 번호를 입력해 주세요.")
        var input = readLine()
        while (input.split(",").size != 6 || input.split(",").map { it.trim() }
                .any { number -> number.toIntOrNull() == null }) {
            println("[ERROR] 쉼표(,)를 기준으로 6개의 숫자를 입력해주세요.")
            input = readLine()
        }
        viewModel.userLottoNumbers = input.split(",").map { it.trim().toInt() }
    }

    override fun readUserBonusNumbers() {
        println("보너스 번호를 입력해 주세요.")
        var input = readLine()
        while (input.toIntOrNull() == null || input.toInt() !in 1..45) {
            println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            input = readLine()
        }
        viewModel.bonusNumber = input.toInt()
    }

    override fun displayLottoResult() {
        println("당첨 통계\n---")
        println(LottoResult.entries.minus(LottoResult.LOSE).joinToString(separator = "\n") { lottoResult ->
            "$lottoResult - ${viewModel.lottoResults.count { userLottoResult -> userLottoResult == lottoResult }}개"
        })
    }

    override fun displayReturnRate() {
        println("총 수익률은 ${viewModel.returnRate}%입니다.")
    }
}