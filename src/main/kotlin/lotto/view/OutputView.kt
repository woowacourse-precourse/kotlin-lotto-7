package lotto.view

object OutputView {
    fun printLotto(lottoList: MutableList<List<Int>>){
        lottoList.forEach { println(it) }
    }
}