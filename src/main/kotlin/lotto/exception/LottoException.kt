package lotto.exception

class LottoException(exceptionCode: ExceptionCode) : IllegalArgumentException(exceptionCode.getMessage())