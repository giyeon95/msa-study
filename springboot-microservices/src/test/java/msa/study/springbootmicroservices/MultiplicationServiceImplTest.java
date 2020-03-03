package msa.study.springbootmicroservices;


import msa.study.springbootmicroservices.domain.Multiplication;
import msa.study.springbootmicroservices.domain.MultiplicationResultAttempt;
import msa.study.springbootmicroservices.domain.User;
import msa.study.springbootmicroservices.service.MultiplicationServiceImpl;
import msa.study.springbootmicroservices.service.RandomGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class MultiplicationServiceImplTest {
    private MultiplicationServiceImpl multiplicationService;

    @Mock
    private RandomGeneratorService randomGeneratorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        multiplicationService = new MultiplicationServiceImpl(randomGeneratorService);
    }

    @Test
    public void createRandomMultiplicationTest() {
        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        Multiplication multiplication = multiplicationService.createRandomMultiplication();

        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        assertThat(multiplication.getResult()).isEqualTo(1500);
    }

    @Test
    public void checkWrongAttemptTest() {
        Multiplication multiplication = Multiplication.builder()
                .factorA(50)
                .factorB(60)
                .result(3000)
                .build();

        User user = User.builder().alias("Kiyeon_kim").build();

        MultiplicationResultAttempt attempt = MultiplicationResultAttempt
                .builder()
                .user(user)
                .multiplication(multiplication)
                .resultAttempt(3010)
                .build();

        boolean attemptResult = multiplicationService.checkAttempt(attempt);

        assertThat(attemptResult).isFalse();

    }
}
