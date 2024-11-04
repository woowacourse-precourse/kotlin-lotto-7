# kotlin-lotto-precourse

## 구현할 기능

- [X] Lotto Class
    - [X] 값을 반환하는 getLottoValue()
- [ ] 결과값을 갖는 enum class LottoResult
- [ ] LottoController
    - [X] 랜덤으로 6개의 숫자를 만들고 이를 Lotto에 저장하는 releaseLotto()
    - [ ] 값을 입력받고 정상적인 입력인지 확인후 저장
    - [X] 입력받은 가격에 따른 로또 구매
    - [ ] 로또 결과를 확인
    - [ ] 최종 결과값 반환
- [ ] 입력과 결과를 다루는 LottoView

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