package lk.travel.authservice.repo;

import lk.travel.authservice.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepo extends JpaRepository<Guide,Integer> {
}
