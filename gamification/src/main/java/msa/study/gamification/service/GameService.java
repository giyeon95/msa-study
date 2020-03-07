package msa.study.gamification.service;

import msa.study.gamification.domain.GameStats;

public interface GameService {


    /**
     * 주어진 사용자가 제출한 답안 처리
     * @param userId 사용자 Id
     * @param attemptId 추가 데이터 조회하기 위한 답안 Id
     * @param correct 답안의 정답 여부
     * @return 새로운 점수와 배지 카드를 포함한 {@link GameStats} 객체
     */

    GameStats newAttemptForUser(Long userId, Long attemptId, boolean correct);

    /**
     * @param userId 사용자 Id
     * @return 사용자 통계정보
     */
    GameStats retrieveStatsForUser(Long userId);

}
