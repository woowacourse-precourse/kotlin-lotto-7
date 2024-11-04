package lotto.model

enum class Prize(count: Int, money: Int) {
    hitThree(3, 5000),
    hitFour(4, 50000),
    hitFive(5, 1500000),
    hitFiveBonus(5, 30000000),
    hitSix(6, 2000000000);
}