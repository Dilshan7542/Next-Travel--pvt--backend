package lk.travel.userserivce.repo;

import lk.travel.userserivce.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepo extends JpaRepository<Guide,Integer> {
}
