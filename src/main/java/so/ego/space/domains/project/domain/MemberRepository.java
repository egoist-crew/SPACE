package so.ego.space.domains.project.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUserId(Long id);

    Optional<Member> findByUserIdAndProjectId(Long user_id, Long project_id);

    void deleteByProjectId(Long id);

    List<Member> findByProjectId(Long id);


}
