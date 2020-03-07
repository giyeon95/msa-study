package msa.study.gamification.repository;

import msa.study.gamification.domain.BadgeCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BadgeCardRepository extends CrudRepository<BadgeCard, Long> {

    List<BadgeCard> findByUserIdOrOrderByBadgeTimestampDesc(final Long userId);
}