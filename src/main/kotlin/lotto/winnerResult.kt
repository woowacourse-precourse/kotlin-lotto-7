package lotto

fun winnerresult(purchase_money: Int, lottoNumber: MutableList<List<Int>>, winnerNumber: List<Int>, bonusNumber: Int) {
    val score_board = MutableList(7) { 0 }
    var five_bonus_conut = 0        // 5개의 번호가 일치했을 때 보너스볼 일치 개수

    for (lottoNum in lottoNumber) {
        val winball = 12 - ((lottoNum + winnerNumber).toSet()).size
        score_board[winball]++
        if (winball == 5 && bonusNumber in lottoNum) five_bonus_conut++
    }
    resultprint(purchase_money, score_board, five_bonus_conut)
}
