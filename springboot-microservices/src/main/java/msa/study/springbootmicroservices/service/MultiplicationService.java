package msa.study.springbootmicroservices.service;

import msa.study.springbootmicroservices.domain.Multiplication;
import msa.study.springbootmicroservices.domain.MultiplicationResultAttempt;

public interface MultiplicationService {

    /**
     * {@link Multiplication}
     * 숫자의 범위 11~99
     * @return 무작위 인수를 담은 {@link Multiplication}
     */
    Multiplication createRandomMultiplication();

    /**
     * 계산결과 반환
     * @return true || false
     */
    boolean checkAttempt(final MultiplicationResultAttempt attempt);
}
