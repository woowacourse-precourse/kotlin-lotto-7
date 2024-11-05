package lotto

enum class Reward(val money : Int) {
    MATCH6(2000000000),
    MATCH5BONUS(30000000),
    MATCH5(1500000),
    MATCH4(50000),
    MATCH3(5000),
    NONE(0)
}