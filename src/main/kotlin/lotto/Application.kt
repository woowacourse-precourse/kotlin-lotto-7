package lotto

fun main() {

    val input=Input()
    val pickNums=PickNums()
    val output=Output()

    var winningNums : List<Int> = listOf(1)
    var bonusNum : Int=-1
    var money : Int=-1
    var pickedNums : ArrayList<List<Int>>


    while (money<0){
        println("구입금액을 입력해 주세요.")
        money = input.getInputMoney()
        if(money<0){
            println("[ERROR] 올바른 숫자를 입력하시오")
        }
    }

    //구매 복권 개수
    val num = money/1000

    pickedNums = pickNums.pickNums(num)

    output.printNums(pickedNums)


    while (winningNums.size!=6){
        println("\n당첨 번호를 입력해 주세요.")
        winningNums=input.getWinningNum()
        try {
            Lotto(winningNums)
        }
        catch (e : IllegalArgumentException){
            println("[ERROR] 올바른 숫자를 입력하시오")
            winningNums= listOf(1)
        }
    }


    while (bonusNum==-1){
        println("\n보너스 번호를 입력해 주세요.")
        bonusNum=input.getBonusNum(winningNums)
    }


    //각 회차 맞은 개수
    val eachPlay : List<Int> = Lotto(winningNums).checkEachPlay(pickedNums,bonusNum,num)
    //전체 결과
    val rank: List<Int> =Lotto(winningNums).getMyRank(eachPlay)
    //전체 결과 출력
    output.printMyRank(rank)

    //수익률 출력
    val prize= Lotto(winningNums).getTotalPrize(eachPlay)

    output.printRevenue(prize, money)




}
