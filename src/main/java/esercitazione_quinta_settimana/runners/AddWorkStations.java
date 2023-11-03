package esercitazione_quinta_settimana.runners;


import esercitazione_quinta_settimana.dao.IBuildingDAO;
import esercitazione_quinta_settimana.dao.IWorkStationDAO;
import esercitazione_quinta_settimana.enteties.Building;
import esercitazione_quinta_settimana.enteties.WorkStation;
import esercitazione_quinta_settimana.enums.WorkStation_Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Order(2)
public class AddWorkStations implements CommandLineRunner {
    @Autowired
    private IWorkStationDAO wDAO;
    @Autowired
    private IBuildingDAO bDAO;

    @Override
    public void run(String... args) throws Exception {
        List<Building> buildings = bDAO.findAll();
        for (int i = 0; i < 100; i++) {
            int n = new Random().nextInt(0, buildings.size());
            Building randomBuilding = buildings.get(n);
            WorkStation randomWorkStation = WorkStation.builder().build();
            randomWorkStation.setBuilding(randomBuilding);
            if (randomWorkStation.getCapacity() <= 10) {
                randomWorkStation.setWorkStationType(WorkStation_Type.PRIVATE);
            } else if (randomWorkStation.getCapacity() <= 40) {
                randomWorkStation.setWorkStationType(WorkStation_Type.MEETING_ROOM);
            } else {
                randomWorkStation.setWorkStationType(WorkStation_Type.OPENSPACE);
            }
            wDAO.save(randomWorkStation);
        }
    }
}
