package repositories;

import enteties.User_WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWorkRepository extends JpaRepository<User_WorkStation, Long> {
}
