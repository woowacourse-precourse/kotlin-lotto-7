package lotto

var purchaseAmount:Int = 0
var pickedNumbers:List<String> = listOf()
var bonusNumber:Int = 0
val lottoStorage:MutableList<MutableList<Int>> = mutableListOf()

fun main()
{
	//구입금액을 입력받습니다
	while (true) {
		try {
			purchaseAmount = getPurchaseAmount()
			break
		} catch (err:Exception) {
			print(err.message)
		}
	}

	print("${purchaseAmount}개를 구매했습니다.\n")

	for (i in 0 until purchaseAmount) {
		var lottoPicked = getLotto()
		println(lottoPicked)
		lottoStorage.add(lottoPicked)
	}
	//당첨번호를 입력받습니다
	while (true) {
		try {
			pickedNumbers = getPickedNumbers()
			break
		} catch (err:Exception) {
			print(err.message)
		}
	}
	//보너스 번호를 입력받습니다
	while (true) {
		try {
			bonusNumber = getBonusNumber()
			break
		} catch (err:Exception) {
			print(err.message)
		}
	}
}
