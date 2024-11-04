package lotto

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

  private lateinit var numbers: List<Int>

  @BeforeEach
  fun setUp() {
    val lotto = Lotto()
    numbers = lotto.getNumbers()
  }

  @Test
  fun `로또 번호는 6개여야 한다`() {
    assertThat(numbers).hasSize(6)
  }

  @Test
  fun `로또 번호는 1에서 45 사이의 숫자여야 한다`() {
    assertThat(numbers).allMatch { it in 1..45 }
  }

  @Test
  fun `로또 번호는 중복되지 않아야 한다`() {
    assertThat(numbers).doesNotHaveDuplicates()
  }

  @Test
  fun `로또 번호의 개수가 6개가 아니면 예외가 발생한다`() {
    assertThrows<IllegalArgumentException> {
      Lotto(listOf(1, 2, 3, 4, 5))
    }
  }

  @Test
  fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
    assertThrows<IllegalArgumentException> {
      Lotto(listOf(1, 2, 3, 4, 5, 5))
    }
  }

  @Test
  fun `로또 번호가 1에서 45 사이를 벗어나는 숫자가 포함되면 예외가 발생한다`() {
    assertThrows<IllegalArgumentException> {
      Lotto(listOf(0, 2, 3, 4, 5, 6))
    }

    assertThrows<IllegalArgumentException> {
      Lotto(listOf(1, 2, 3, 4, 5, 46))
    }
  }
}