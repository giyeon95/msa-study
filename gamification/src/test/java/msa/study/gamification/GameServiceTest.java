package msa.study.gamification;

import msa.study.gamification.domain.GameStats;
import msa.study.gamification.domain.ScoreCard;
import msa.study.gamification.repository.ScoreCardRepository;
import msa.study.gamification.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = GamificationApplication.class)
@SpringBootTest
public class GameServiceTest {

//    private GameService gameService;
//
//    @Mock
//    private ScoreCardRepository scoreCardRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void newAttemptForUserTest() {
//        Long userId = 1L;
//        Long attemptId = 8L;
//        int totalScore = 10;
//
//        ScoreCard scoreCard = new ScoreCard(userId, attemptId);
//        given(scoreCardRepository.getTotalScoreForUser(userId)).willReturn(totalScore);
//
//
//
//    }

}
