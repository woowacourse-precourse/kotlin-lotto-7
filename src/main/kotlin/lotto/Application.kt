package lotto

fun main() {
    // TODO: 프로그램 구현
    val inputView = InputView()
    val outputView = OutputView()
    val lottoDraw = LottoDraw()
    lottoDraw.run(inputView, outputView)
}
