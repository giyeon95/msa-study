package msa.study.springbootmicroservices.service;

import msa.study.springbootmicroservices.domain.Multiplication;

public interface MultiplicationService {

    /**
     * {@link Multiplication}
     * 숫자의 범위 11~99
     * @return 무작위 인수를 담은 {@link Multiplication}
     */
    Multiplication createRandomMultiplication();

}
