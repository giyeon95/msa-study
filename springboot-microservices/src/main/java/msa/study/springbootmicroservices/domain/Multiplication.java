package msa.study.springbootmicroservices.domain;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@Builder
public class Multiplication {
    private int factorA;
    private int factorB;

    private int result;
}
