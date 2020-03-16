package msa.study.springbootmicroservices.controller;

import lombok.extern.slf4j.Slf4j;
import msa.study.springbootmicroservices.domain.Multiplication;
import msa.study.springbootmicroservices.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/multiplications")
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MultiplicationController {

    @Autowired
    private final MultiplicationService multiplicationService;

    private final int serverPort;


    public MultiplicationController(final MultiplicationService multiplicationService, @Value("${server.port}") int serverPort) {
        this.multiplicationService = multiplicationService;
        this.serverPort = serverPort;
    }


    @GetMapping("/random")
    Multiplication getRandomMultiplication() {
        log.info("무작위 곱셈이 생성된 서버 @ {}", serverPort);
        return multiplicationService.createRandomMultiplication();
    }

}
