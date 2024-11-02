package lotto.di

import lotto.domain.usecase.*

class AppContainer {
    val createUserUseCase by lazy { CreateUserUseCase() }
    val createLottoUseCase by lazy { CreateLottoUseCase() }
    val createWinningNumbersUseCase by lazy { CreateWinningNumbersUseCase() }
    val createBonusNumberUseCase by lazy { CreateBonusNumberUseCase() }
    val calculateLottoRankUseCase by lazy { CalculateLottoRankUseCase() }
    val calculateLottoReturnUseCase by lazy { CalculateLottoReturnUseCase() }
}