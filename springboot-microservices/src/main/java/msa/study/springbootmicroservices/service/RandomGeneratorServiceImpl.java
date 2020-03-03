package msa.study.springbootmicroservices.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class RandomGeneratorServiceImpl implements RandomGeneratorService {


    @Override
    public int generateRandomFactor() {
        return ((int)(Math.random() * 89)+ 11);
    }
}
