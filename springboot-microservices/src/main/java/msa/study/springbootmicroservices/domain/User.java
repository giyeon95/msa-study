package msa.study.springbootmicroservices.domain;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
public final class User {
    private final String alias;

    protected User() {
        alias = null;
    }
}
