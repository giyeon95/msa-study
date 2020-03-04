package msa.study.springbootmicroservices.service;

import lombok.AllArgsConstructor;
import msa.study.springbootmicroservices.domain.Multiplication;
import msa.study.springbootmicroservices.domain.MultiplicationResultAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB  = randomGeneratorService.generateRandomFactor();

        return Multiplication.builder()
                .factorA(factorA)
                .factorB(factorB)
                .result(factorA * factorB)
                .build();
    }

    @Override
    public boolean checkAttempt(MultiplicationResultAttempt attempt) {
        boolean correct = attempt.getResultAttempt() ==
                attempt.getMultiplication().getFactorA() * attempt.getMultiplication().getFactorB();

        Assert.isTrue(!attempt.isCorrect());

        MultiplicationResultAttempt checkAttempt = new MultiplicationResultAttempt(attempt.getUser(), attempt.getMultiplication(), attempt.getResultAttempt(), correct);

        return correct;
    }
}
