package lotto
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*

fun main() {
    // TODO: 프로그램 구현
    // 로또 구입 금액 입력
    val money = readInt("구입금액을 입력해 주세요.", 0)

    val ticketNumber = money / 1000;
    val change = money % 1000;

    // 당첨 번호 입력
    val lottoNumbers = readArray("당첨 번호를 입력해 주세요.")
    // 보너스 번호 입력
    val bonus = readInt("구입금액을 입력해 주세요.", 1)


}

fun readInt(message: String, mode: Int): Int{
    var number = 0;
    var stop = false;
    while(!stop){
        println(message);
        stop = true;
        try{
            number = Console.readLine().toInt();
            if ((mode == 0 && number < 0) || (mode == 1 && (number < 1 || number > 45))) throw NumberFormatException()
        }
        catch (e: NumberFormatException){
            println("Exception in thread \"main\" java.lang.IllegalArgumentException: [ERROR]: you enter the wrong type\n");
            stop = false;
        }
    }
    return number;
}

fun readArray(message: String): MutableList<Int> {
    var arr: MutableList<Int> = mutableListOf()
    var stop = false;
    while(!stop){
        println(message);
        stop = true;
        try{
            arr = makeArray(Console.readLine());
        }
        catch (e: NumberFormatException){
            println("Exception in thread \"main\" java.lang.IllegalArgumentException: [ERROR]: you enter the wrong type\n");
            stop = false;
            continue;
        }
    }
    return arr;
}

fun makeArray(input: String): MutableList<Int> {
    val arr: MutableList<Int> = mutableListOf()
    val st = StringTokenizer(input, ",")
    while(st.hasMoreTokens()){
        val number = st.nextToken().toInt()
        if (number < 1 || number > 45) throw NumberFormatException()
        arr.add(number)
    }
    if (arr.size != 6){
        throw NumberFormatException()
    }
    return arr
}
