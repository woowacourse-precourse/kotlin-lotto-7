package lotto.model

class LottoGenerator {
    private val lottoes =  mutableListOf <Lotto>()
    fun makeLotto(count :Int){
        val random = Random()
        repeat(count){
            lottoes.add(Lotto(random.generate()))
        }
    }

    fun getLottoes():List<Lotto>{
        return lottoes
    }
}