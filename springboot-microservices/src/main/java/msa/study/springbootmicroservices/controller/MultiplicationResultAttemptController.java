package msa.study.springbootmicroservices.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import msa.study.springbootmicroservices.domain.MultiplicationResultAttempt;
import msa.study.springbootmicroservices.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/results")
final class MultiplicationResultAttemptController {

  @Autowired
  private final MultiplicationService multiplicationService;
  private final int serverPort;

  public MultiplicationResultAttemptController(@Autowired final MultiplicationService multiplicationService,@Value("${server.port}") int serverPort) {
    this.multiplicationService = multiplicationService;
    this.serverPort = serverPort;
  }


  @PostMapping
  ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
    boolean isCorrect = multiplicationService.checkAttempt(multiplicationResultAttempt);
    MultiplicationResultAttempt attemptCopy = new MultiplicationResultAttempt(
            multiplicationResultAttempt.getUser(),
            multiplicationResultAttempt.getMultiplication(),
            multiplicationResultAttempt.getResultAttempt(),
            isCorrect
    );


    return ResponseEntity.ok(attemptCopy);
  }

  @GetMapping
  ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(@RequestParam("alias") String alias) {
    return ResponseEntity.ok(multiplicationService.getStatsForUser(alias));
  }

  @GetMapping("/{resultId}")
  ResponseEntity<MultiplicationResultAttempt> getResultById(final @PathVariable("resultId") Long resultId) {

    log.info("조회 결과 {} 를 가져온 서버 @ {}", resultId, serverPort);
    return ResponseEntity.ok(multiplicationService.getResultById(resultId));
  }
}
