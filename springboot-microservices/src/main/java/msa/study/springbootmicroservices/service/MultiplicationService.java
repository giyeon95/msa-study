package msa.study.springbootmicroservices.service;

import msa.study.springbootmicroservices.domain.Multiplication;
import msa.study.springbootmicroservices.domain.MultiplicationResultAttempt;

import java.util.List;

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


    List<MultiplicationResultAttempt> getStatsForUser(String userAlias);

    /**
     * ID에 해당하는 답안 조회
     *
     * @param resultId 답안의 식별자
     * @return ID에 해당하는 {@link MultiplicationResultAttempt} 객체, 없으면 null
     */
    MultiplicationResultAttempt getResultById(final Long resultId);
}
