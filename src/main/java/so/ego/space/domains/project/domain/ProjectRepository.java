package so.ego.space.domains.project.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "SELECT * FROM PROJECT P INNER JOIN MEMBER M ON P.ID = M.PROJECT_ID INNER JOIN USER U ON M.USER_ID = U.ID WHERE USER_ID = :user_id", nativeQuery = true)
    List<Project> findMyProject(Long user_id);

    @Query(value = "SELECT COUNT(*) FROM PROJECT P INNER JOIN TASK T ON P.ID = T.PROJECT_ID WHERE P.ID = :project_id", nativeQuery = true)
    Long countByTaskAll(Long project_id);

    @Query(value = "SELECT COUNT(*) FROM PROJECT P INNER JOIN TASK T ON P.ID = T.PROJECT_ID WHERE P.ID = :project_id AND T.STATUS = 'DONE'", nativeQuery = true)
    Long countByTaskDone(Long project_id);

}
