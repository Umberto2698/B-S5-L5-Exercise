package esercitazione_quinta_settimana.repositories;

import esercitazione_quinta_settimana.enteties.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
