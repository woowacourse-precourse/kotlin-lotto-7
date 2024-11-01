package lotto

var purchaseAmount:Int = 0
var pickedNumbers:MutableList<Int> = mutableListOf()
var bonusNumber:Int = 0
val lottoStorage:MutableList<MutableList<Int>> = mutableListOf()
var resultStorage:MutableList<Price> = mutableListOf()

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

	for (numbers in lottoStorage) {
		var price = Lotto(numbers).determineWith(pickedNumbers, bonusNumber)
		resultStorage.add(price)
	}
	var countMap = resultStorage.groupingBy { it }.eachCount()
	var fifthCount = countMap[Price.FIFTH]
	var fourthCount = countMap[Price.FOURTH]
	var thirdCount = countMap[Price.THIRD]
	var secondCount = countMap[Price.SECOND]
	var firstCount = countMap[Price.FIRST]
	print("""
		3개 일치 (5,000원) - ${fifthCount}개
		4개 일치 (50,000원) - ${fourthCount}개
		5개 일치 (1,500,000원) - ${thirdCount}개
		5개 일치, 보너스 볼 일치 (30,000,000원) - ${secondCount}개
		6개 일치 (2,000,000,000원) - ${firstCount}개
	""".trimIndent()
	)
}
