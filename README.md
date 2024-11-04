# kotlin-lotto-precourse

## 구현할 기능

- [X] Lotto Class
    - [X] 값을 반환하는 getLottoValue()
- [X] 결과값을 갖는 enum class LottoResult
- [X] LottoController
    - [X] 랜덤으로 6개의 숫자를 만들고 이를 Lotto에 저장하는 releaseLotto()
    - [X] 값을 입력받고 정상적인 입력인지 확인후 저장
    - [X] 입력받은 가격에 따른 로또 구매
    - [X] 로또 결과를 확인
    - [X] 최종 결과값 반환
- [X] 입력과 결과를 다루는 LottoView

## 구현 과정

### releaseLotto()

Lotto 목록을 저장하는 ArrayList lottos에 getLottoNumber()를 통해 랜덤 로또 번호를 반환하여 만든 Lotto를 add한다.

```
private fun releaseLotto() {
        lottos.add(Lotto(getLottoNumber()))
    }
    
    private fun getLottoNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}
```

### 로또 구매

```
fun getBuyAmount(): Int {
        println(Constant.INPUT_BUY_MESSAGE)
        return Console.readLine().toInt()
    }

fun showBoughtLotto(lottoAmount: Int, lottos: ArrayList<Lotto>) {
    println("\n$lottoAmount" + Constant.BOUGHT_LOTTO_MESSAGE)
    println(lottos.joinToString("\n") { "[" + it.getLottoValue().joinToString(", ") + "]" })
    println()
}
```
LottoView를 통해 값을 입력받는다.
이때 직접적으로 입출력값을 하드코딩하지 말라했던 2주차 피드백을 참고하여 출력메시지를 Constant 오브젝트에 모두 const val로 별도로 저장해주었다.


```
   fun startLotto() {
        val lottoView = LottoView()
        val buyLottoAmount = divideLottoPrice(lottoView.getBuyAmount())
        releaseLotto(buyLottoAmount)
        lottoView.showBoughtLotto(buyLottoAmount, lottos)
    }

    private fun divideLottoPrice(inputBuyAmount: Int): Int {
        return inputBuyAmount / Constant.LOTTO_PRICE
    }

    private fun releaseLotto(buyLottoAmount: Int) {
        repeat(buyLottoAmount) {
            lottos.add(Lotto(getLottoNumber()))
        }
    }
```
입력받은 값을 LOTTO_PRICE로 나누고 이를 통해 도출된 구매 갯수에 따라 releaseLotto()를 통해 Lotto를 발매한다.

### 로또 결과 정산
```
private fun calculateLotto(winnerNumber: List<Int>, specialNumber: Int): List<Int> {
        val lottoResult = MutableList(5) { 0 }
        lottos.forEach {
            when (it.getLottoValue().toSet().minus(winnerNumber.toSet()).size) {
                3 -> lottoResult[0]++
                2 -> lottoResult[1]++
                1 -> {
                    if (it.getLottoValue().contains(specialNumber)) lottoResult[3]++
                    else lottoResult[2]++
                }

                0 -> lottoResult[4]++
            }
        }
        return lottoResult
    }
```
입력받은 로또 당첨 번호와 발매된 로또 번호의 공통 개수 비교 및 보너스 볼 넘버를 비교하고 그 갯수를 누적한다.

```
private fun getReturnRate(lottoResult: List<Int>, buyLottoAmount: Int) : Double{
        var sum = 0.0
        sum += Constant.THREE_REWARD * lottoResult[0]
        sum += Constant.FOUR_REWARD * lottoResult[1]
        sum += Constant.FIVE_REWARD * lottoResult[2]
        sum += Constant.FIVE_SPECIAL_REWARD * lottoResult[3]
        sum += Constant.SIX_REWARD * lottoResult[4]
        return sum/(buyLottoAmount*Constant.LOTTO_PRICE)
    }
```
calculateLotto로 얻어낸 lottoResult를 통해 총 수익률을 구하고 이 값들을 LottoView로 전달해주어
```
fun showLottoResult(lottoResult : List<Int>){
        println(Constant.RESULT_MESSAGE)
        println(Constant.RESULT_THREE_MATCH.format(lottoResult[0]))
        println(Constant.RESULT_FOUR_MATCH.format(lottoResult[1]))
        println(Constant.RESULT_FIVE_MATCH.format(lottoResult[2]))
        println(Constant.RESULT_FIVE_SPECIAL_MATCH.format(lottoResult[3]))
        println(Constant.RESULT_SIX_MATCH.format(lottoResult[4]))
    }

    fun showReturnRate(returnRate : Double){
        println("총 수익률은 ${String.format("%.1f", returnRate)}%입니다.")
    }

```

이것을 사용자에게 출력한다.

## enum Class 추가
```
enum class LottoResult(val prize: Int) {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_SPECIAL(30000000),
    SIX(2000000000)
}
```

## 예외처리
각 입력에 대해서는 유효하지 않을 경우 해당 입력을 다시 받아야하므로 각 입력에 대해서 
```
fun getSpecialNumber(winnerNumber: List<Int>): Int {
        while (true) {
            try {
                println(Constant.INPUT_SPECIAL_NUMBER_MESSAGE)
                val specialNumber = Console.readLine()
                if (checkSpecialNumber(specialNumber, winnerNumber)) return specialNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun checkSpecialNumber(specialNumber: String, winnerNumber: List<Int>): Boolean {
        try {
            if (specialNumber.toInt() in 1..45) {
                if (!winnerNumber.contains(specialNumber.toInt())) return true
                else throw Exception()
            } else throw Exception()
        } catch (e: Exception) {
            throw IllegalArgumentException(Constant.ERROR_SPECIAL_NUMBER_INVALID_MESSAGE)
        }
    }
```

와 같은 연산을 통해 유효성 검사를 수행한다.

## 테스트 추가
```
@Test
    fun `로또 번호가 1에서 45 사이의 숫자가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }
```
로또 번혹가 1~45 사이인지 확인하는 테스트를 추가해주었다.