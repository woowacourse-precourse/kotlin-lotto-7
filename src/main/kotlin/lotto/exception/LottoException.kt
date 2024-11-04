package lotto.exception

class LottoException(exceptionCode: ExceptionCode) : RuntimeException(exceptionCode.getMessage())
//: LottoException의 부모 클래스