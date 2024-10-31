package lotto.exception

class LottoException(exceptionCode: ExceptionCode) : RuntimeException(exceptionCode.getMessage())