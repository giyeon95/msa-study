package msa.study.springbootmicroservices.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @NonNull private String alias;
}
