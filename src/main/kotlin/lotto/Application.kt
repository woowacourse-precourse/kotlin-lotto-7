package lotto

fun main() {
    // 구매 금액 입력
    val purchaseView = PurchaseView()
    val purchasedLottoCount = purchaseView.getPurchaseLottoCount()

    // 로또 발행
    val user = User(purchasedLottoCount) // 구매하는 갯수를 통해 User 인스턴스 생성
    purchaseView.displayLottos(user) // user의 구매한 로또 개수, 로또 번호 출력

    // 로또 당첨 번호 입력
    val resultView = ResultView()
    val winningNumbers = resultView.getWinningNumbers()
    val bonusNumber = resultView.getBonusNumber(winningNumbers)
    LotteryMachine.setWinningLotto(winningNumbers, bonusNumber) // LotteryMachine의 당첨 번호와 보너스 번호 설정

    // 당첨 등수, 수익률 계산 및 출력
    val resultCalculator = ResultCalculator()
    val results = resultCalculator.calculateResults(user)
    val profitRate = resultCalculator.calculateProfitRate(user)
    resultView.displayResults(results, profitRate)
}
