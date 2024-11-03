package lotto

class Output {

    fun printNums(pickedNums : ArrayList<List<Int>>){
        for (i in pickedNums){
            var result : String ="["
            for (j in i){
                result+="$j, "
            }
            result=result.substring(0,result.length-2)
            print("$result]\n")
        }
    }

    fun printMyRank(count: List<Int>) {
        print(
            "\n당첨 통계\n" +
                    "---\n" +
                    "3개 일치 (5,000원) - ${count[0]}개\n" +
                    "4개 일치 (50,000원) - ${count[1]}개\n" +
                    "5개 일치 (1,500,000원) - ${count[2]}개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - ${count[3]}개\n" +
                    "6개 일치 (2,000,000,000원) - ${count[4]}개\n"
        )
    }

    fun printRevenue(prize: Int, money: Int) {
        var result = String.format("%.1f", prize.toDouble() / money.toDouble()*100)
        print("총 수익률은 $result%입니다.")
    }
}