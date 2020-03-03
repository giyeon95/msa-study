package msa.study.springbootmicroservices.service;

import lombok.AllArgsConstructor;
import msa.study.springbootmicroservices.domain.Multiplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
