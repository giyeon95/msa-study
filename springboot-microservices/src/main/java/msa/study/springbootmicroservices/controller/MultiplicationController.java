package msa.study.springbootmicroservices.controller;

import lombok.AllArgsConstructor;
import msa.study.springbootmicroservices.domain.Multiplication;
import msa.study.springbootmicroservices.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multiplications")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MultiplicationController {
    private final MultiplicationService multiplicationService;

    @GetMapping("/random")
    Multiplication getRandomMultiplication() {
        return multiplicationService.createRandomMultiplication();
    }

}
