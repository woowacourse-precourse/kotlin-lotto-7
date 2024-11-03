package lotto

enum class Prize (val count: Int, val money: Int) {

    first(3,5000),
    second(4,50000),
    thrid(5,1500000),
    fourth(-5,30000000),
    fifth(6,2000000000);
}