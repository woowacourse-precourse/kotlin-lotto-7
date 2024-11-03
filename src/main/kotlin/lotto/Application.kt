package lotto

fun main() {
    val purchaseView = PurchaseView()
    val purchasedLottoCount = purchaseView.getPurchaseLottoCount() // 구매하는 로또 개수
    val user = User(purchasedLottoCount) // 구매하는 갯수를 통해 User 인스턴스 생성
    purchaseView.displayLottos(user) // user의 구매한 로또 개수, 로또 번호 출력

    val resultView = ResultView()
    val winningNumbers = resultView.getWinningNumbers() // 당첨 번호
    val bonusNumber = resultView.getBonusNumber(winningNumbers) // 보너스 번호
    LotteryMachine.setWinningLotto(winningNumbers, bonusNumber) // LotteryMachine의 당첨 번호와 보너스 번호 설정
}
