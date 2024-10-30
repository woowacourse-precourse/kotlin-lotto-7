package lotto

import di.DependencyInjector
import view.InputView

fun main() {
    val injector = DependencyInjector()
    val inputValidator = injector.injectInputValidator()
    InputView(inputValidator)
}