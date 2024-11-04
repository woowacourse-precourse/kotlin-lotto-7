package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readLine(): String {
        return Console.readLine().trim()
    }
}