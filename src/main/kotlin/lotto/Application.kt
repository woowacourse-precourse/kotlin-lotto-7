package lotto

import lotto.app.DependencyInjector

fun main() {
    val injector = DependencyInjector()
    injector.injectView()
}