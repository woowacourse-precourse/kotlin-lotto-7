package lotto

class LottoStore {
    private val randomLottos = mutableListOf<List<Int>>()
    private val lottoGameView = LottoGameView()
    private val lottoSeller = LottoSeller()
    private val user = User()

    fun startSellLotto() {
        lottoGameView.startInputLottoMoney()
        val seller = lottoSeller.generateLottoNumbers(lottoTicketNum())
        showRandomLotto(seller)
        lottoGameView.inputUserLottoNumber()
        val lottoNumbers = user.getLottoNumber()
        lottoGameView.inputBonusNumber()
        val bonusNum = checkBonusNum(lottoNumbers)
        resultLotto(lottoNumbers, bonusNum)
    }

    private fun checkBonusNum(lotto: List<Int>): Int {
        return try {
            lottoSeller.checkLottoHasBonusNum(lotto, user.inputBonusNum())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            lottoSeller.checkLottoHasBonusNum(lotto, user.inputBonusNum())
        }
    }

    private fun lottoTicketNum(): Int = lottoSeller.lottoTicketCount(userInput())

    private fun userInput(): String {
        //유효성 검사가 잘 되었으면 그 입력한 돈을 int로 바꾸고 티켓으로 변환해야겠죠?
        return try {
            val money = User().inputMoney()
            lottoSeller.checkTicketMoneyValidate(money)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            userInput()
        }
    }

    private fun showRandomLotto(randomLotto: List<LottoNumberGenerator>) {
        println("${randomLotto.size}개를 구매했습니다.")
        for (lotto in randomLotto) {
            val machineLottoNumbers = lotto.generate()
            println(machineLottoNumbers)
            randomLottos.add(machineLottoNumbers)
        }
    }

    private fun resultLotto(lottoNumbers: List<Int>, isBonusValid: Int) {
        val lottoResult = Calculator()
        lottoResult.compareNum(lottoNumbers, isBonusValid, randomLottos)
        lottoGameView.printMatchedNumbersCount(lottoResult)
        lottoGameView.printProfitRate(lottoResult.calculateProfitRate())
    }
}
