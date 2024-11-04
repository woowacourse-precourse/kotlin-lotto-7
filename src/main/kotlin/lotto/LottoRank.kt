package lotto

enum class LottoRank(val priceONE:String,val price:Int,val matchCount:Int,val bonusMatch:Boolean) {
    ONE("2,000,000,000원",2000000000,6,false),
    TWO("30,000,000원",30000000,5,true),
    THREE("1,500,000원",1500000,5,false),
    FOUR("50,000원",50000,4,false),
    FIVE("5,000원",5000,3,false),
    LOSE("0원",0,0,false)
}