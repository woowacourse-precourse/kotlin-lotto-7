package lotto

import camp.nextstep.edu.missionutils.Randoms as ran

class PickNums {
    // 랜덤으로 값 산출
    fun pickNums( num : Int): ArrayList<List<Int>> {
        var pickedNums : ArrayList<List<Int>> = arrayListOf<List<Int>>()
        println("\n"+num.toString()+"개를 구매했습니다.")

        for (i :Int in 0..<num){
            pickedNums.add(ran.pickUniqueNumbersInRange(1,45,6))
        }
        return pickedNums
    }
}