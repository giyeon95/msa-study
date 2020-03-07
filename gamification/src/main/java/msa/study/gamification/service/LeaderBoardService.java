package msa.study.gamification.service;

import msa.study.gamification.domain.LeaderBoardRow;

import java.util.List;

public interface LeaderBoardService {

    List<LeaderBoardRow> getCurrentLeaderBoard();
}
