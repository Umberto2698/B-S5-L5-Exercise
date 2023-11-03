package esercitazione_quinta_settimana;

import esercitazione_quinta_settimana.dao.IWorkStationDAO;
import esercitazione_quinta_settimana.enteties.WorkStation;
import esercitazione_quinta_settimana.enums.WorkStation_Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EsercitazioneQuintaSettimanaApplicationTests {
    @Autowired
    private IWorkStationDAO wDAO;

    @Test
    void findByWorkStationType() {
        List<WorkStation> workStations = wDAO.findByType(WorkStation_Type.PRIVATE);
        assertEquals(8, workStations.size());
    }
}
