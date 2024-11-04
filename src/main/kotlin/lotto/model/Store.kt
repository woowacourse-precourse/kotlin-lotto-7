package lotto.model

interface Store {
    fun sell(): List<Int>
}