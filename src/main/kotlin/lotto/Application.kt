package lotto

fun main() {
    val purchaseView = PurchaseView()
    val purchasedLottoCount = purchaseView.getPurchaseLottoCount() // 구매하는 로또 개수
    val user = User(purchasedLottoCount) // 구매하는 갯수를 통해 User 인스턴스 생성
    purchaseView.displayLottos(user) // user의 구매한 로또 개수, 로또 번호 출력

    val resultView = ResultView()
    val winningNumbers = resultView.getWinningNumbers()
    val bonusNumber = resultView.getBonusNumber()
    LotteryMachine.setWinningLotto(winningNumbers, bonusNumber)

}
