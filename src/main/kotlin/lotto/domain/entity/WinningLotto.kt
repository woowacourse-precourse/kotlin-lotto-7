package lotto.domain.entity

enum class WinningLotto(val rewardPrice: Int, val amount: Int) {
    Three(RewardPrice.PRICE_OF_THREE_WIN, 0),
    Four(RewardPrice.PRICE_OF_FOUR_WIN, 0),
    Five(RewardPrice.PRICE_OF_FIVE_WIN, 0),
    FiveBonus(RewardPrice.PRICE_OF_FIVE_BONUS_WIN, 0),
    Six(RewardPrice.PRICE_OF_SIX_WIN, 0)
}