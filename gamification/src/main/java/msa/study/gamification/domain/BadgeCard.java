package msa.study.gamification.domain;

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
public final class BadgeCard {

    @Id
    @GeneratedValue
    @Column(name = "BADGE_ID")
    @NonNull
    private Long badgeId;

    @NonNull
    private Long userId;

    @NonNull
    private long badgeTimestamp;
    @NonNull
    private Badge badge;

    public BadgeCard(final Long userId, final Badge badge) {
        this(null, userId, System.currentTimeMillis(), badge);
    }



}
