package msa.study.springbootmicroservices.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import msa.study.springbootmicroservices.domain.MultiplicationResultAttempt;
import msa.study.springbootmicroservices.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/results")
final class MultiplicationResultAttemptController {

  private final MultiplicationService multiplicationService;

  @PostMapping
  ResponseEntity<ResultResponse> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
    return ResponseEntity.ok(
            new ResultResponse(multiplicationService.checkAttempt(multiplicationResultAttempt))
    );
  }

  @RequiredArgsConstructor
  @NoArgsConstructor(force = true)
  @Getter
  static final class ResultResponse {
    private final boolean correct;
  }
}
