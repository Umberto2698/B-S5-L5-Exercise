package esercitazione_quinta_settimana.repositories;

import esercitazione_quinta_settimana.enteties.WorkStation;
import esercitazione_quinta_settimana.enums.WorkStation_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkStationRepository extends JpaRepository<WorkStation, Long> {
    List<WorkStation> findByWorkStationType(WorkStation_Type workStationType);

    @Query("SELECT w FROM WorkStation w WHERE building.city LIKE ?1%")
    List<WorkStation> getWorkStationFromCityIgnoreCase(String city);

    //    @Query(value = "SELECT * FROM work_stations w WHERE w.type LIKE 'OPENSPACE' AND w.building_id IN (SELECT id FROM buildings b WHERE LOWER(b.city) LIKE LOWER('settimo%'))", nativeQuery = true)
    // ************* Ho un problema nell'uso di LOWER, Spring non lo supporta come annotazione all'interno delle query ma permette di mettere IgnoreCase/AllIgnoreCase nel nome del metodo.
    // ************* Ma credo che se utilizzo più di una variabile nel metodo non riesce ad applicare il IgnoreCase/AllIgnoreCase anche se inserito.
    @Query(value = "SELECT w FROM WorkStation w WHERE w.workStationType LIKE ?1 AND w.building.id IN (SELECT id FROM Building b WHERE b.city LIKE ?2%)")
    List<WorkStation> getWorkStationFromCity(WorkStation_Type workStationType, String city);
}
