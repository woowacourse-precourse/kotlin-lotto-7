package lotto.controller.dto

import lotto.domain.enum.Prize

data class WinningStatisticsDto(val winningStatisticsDto: Map<Prize, Int>)
