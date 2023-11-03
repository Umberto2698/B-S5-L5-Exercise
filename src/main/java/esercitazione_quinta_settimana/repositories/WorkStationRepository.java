package esercitazione_quinta_settimana.repositories;

import esercitazione_quinta_settimana.enteties.WorkStation;
import esercitazione_quinta_settimana.enums.WorkStation_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkStationRepository extends JpaRepository<WorkStation, Long> {
    List<WorkStation> findByWorkStationType(WorkStation_Type workStationType);
}
