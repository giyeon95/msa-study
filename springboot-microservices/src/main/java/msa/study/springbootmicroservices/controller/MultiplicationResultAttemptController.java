package msa.study.springbootmicroservices.controller;

import lombok.RequiredArgsConstructor;
import msa.study.springbootmicroservices.domain.Multiplication;
import msa.study.springbootmicroservices.domain.MultiplicationResultAttempt;
import msa.study.springbootmicroservices.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/results")
final class MultiplicationResultAttemptController {

  private final MultiplicationService multiplicationService;


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
    return ResponseEntity.ok(multiplicationService.getResultById(resultId));
  }
}
