package lotto

class IOHandler {
    fun inputToUser(instruction: String): String {
        val exceptionOfNull = "입력값을 확인할 수 없습니다. 다시 입력해주세요."

        println(instruction)
        return readLine() ?: exceptionOfNull
    }
}