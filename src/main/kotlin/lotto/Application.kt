package lotto
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*
import kotlin.math.roundToInt

fun main() {
    // TODO: 프로그램 구현
    // 로또 구입 금액 입력
    val money = readInt(Message.MONEY.str, 0)
    val ticketNumber = money / 1000;
    val change = money % 1000;
    val records: MutableList<Int> = mutableListOf<Int>(0, 0, 0, 0, 0)
    val tickets: MutableList<MutableList<Int>> = mutableListOf()
    val result:Long = 0;
    makeTickets(ticketNumber, tickets)
    // 당첨 번호 입력
    // 완성
    val lottoNumbers = readArray(Message.LOTTO.str)
    // 보너스 번호 입력
    var bonus: Int
    do {
        bonus = readInt(Message.BONUS.str, 1)
    }while (bonus == 0 || lottoNumbers.contains(bonus))
    getResult(tickets, lottoNumbers, bonus, records, result, change, money)

}

private fun getResult(
    tickets: MutableList<MutableList<Int>>,
    lottoNumbers: MutableList<Int>,
    bonus: Int,
    records: MutableList<Int>,
    result: Long,
    change: Int,
    money: Int
) {
    var resultMoney = result
    for (ticket in tickets) {
        checkTicket(ticket, lottoNumbers, bonus, records)
    }
    print("당첨 통계\n---\n3개 일치 (5,000원) - ${records[0]}개\n4개 일치 (50,000원) - ${records[1]}개\n5개 일치 (1,500,000원) - ${records[2]}개\n5개 일치, 보너스 볼 일치 (30,000,000원) - ${records[3]}개\n6개 일치 (2,000,000,000원) - ${records[4]}개\n")
    resultMoney = change.toLong()
    for (i in 0..4) {
        resultMoney += LottoRanking.entries.get(i).price.toLong() * records[i]
    }
    val rate: Double = resultMoney.toDouble() / money.toDouble();
    println("총 수익률은 ${(rate * 1000).roundToInt().toDouble() / 10}%입니다.");
}

fun getBenefitRate(money: Int, change: Int, records: MutableList<Int>): String {
    var result = change
    for(i in 0 .. 4){
        result += LottoRanking.entries.get(i).price;
    }
    println(result);
    val realNum: Double = money.toDouble() / result.toDouble()
    return realNum.toString()
}

private fun makeTickets(
    ticketNumber: Int,
    tickets: MutableList<MutableList<Int>>
) {
    print(ticketNumber)
    println("개를 구매했습니다.")
    for (i: Int in 1..ticketNumber) {
        tickets.add(makeLotto())
    }
}

fun checkTicket(ticket: MutableList<Int>, lottoNumbers: MutableList<Int>, bonus: Int, records: MutableList<Int>){
    val match = countMatch(ticket, lottoNumbers, bonus)
    if (match==3) records[LottoRanking.FIFTH.ordinal]++
    if (match==4) records[LottoRanking.FOURTH.ordinal]++
    if (match==5) records[LottoRanking.THIRD.ordinal]++
    if (match==-5) records[LottoRanking.SECOND.ordinal]++
    if (match==6) records[LottoRanking.FIRST.ordinal]++
    return
}

fun countMatch(ticket: MutableList<Int>, lottoNumbers: MutableList<Int>, bonus: Int): Int{
    var match = 0;
    for (i in lottoNumbers){
        if (ticket.contains(i)){
            match++;
        }
    }
    if (match == 5 && ticket.contains(bonus)) {
        match *= -1
    }
    return match
}

fun makeLotto(): MutableList<Int> {
    val arr = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    println(arr)
    return arr;
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
            println(e.message);
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
        if (number < 1 || number > 45) throw NumberFormatException(Message.TYPEERROR.str)
//        if (arr.contains(number)) throw NumberFormatException(Message.STATEERROR.str)
        arr.add(number)
    }
    if (arr.size != 6){
        throw NumberFormatException()
    }
    return arr
}



enum class Message(val str: String){
    MONEY("구입금액을 입력해 주세요."),
    LOTTO("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요."),
    TYPEERROR("Exception in thread \"main\" java.lang.IllegalArgumentException: [ERROR]: you enter the wrong type\n"),
    STATEERROR("Exception in thread \"main\" java.lang.IllegalStateException: [ERROR]: lotto numbers cannot be duplication\n")
}

enum class LottoRanking(val price:Int){
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000)
}