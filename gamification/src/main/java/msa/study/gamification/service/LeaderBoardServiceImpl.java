package msa.study.gamification.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import msa.study.gamification.domain.LeaderBoardRow;
import msa.study.gamification.repository.ScoreCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor(force = true)
public class LeaderBoardServiceImpl implements LeaderBoardService {

    private final ScoreCardRepository scoreCardRepository;

    @Override
    public List<LeaderBoardRow> getCurrentLeaderBoard() {
        return scoreCardRepository.findFirst10();
    }
}
