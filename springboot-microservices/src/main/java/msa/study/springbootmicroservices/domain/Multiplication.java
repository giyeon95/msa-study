package msa.study.springbootmicroservices.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public final class Multiplication {

    @Id
    @GeneratedValue

    @Column(name = "MULTIPLICATION_ID")
    private Long id;

    @NonNull private int factorA;
    @NonNull private int factorB;

}
