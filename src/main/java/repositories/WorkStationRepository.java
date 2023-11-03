package repositories;

import enteties.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkStationRepository extends JpaRepository<WorkStation, Long> {
}
