package esercitazione_quinta_settimana.services;

import esercitazione_quinta_settimana.dao.IBuildingDAO;
import esercitazione_quinta_settimana.enteties.Building;
import esercitazione_quinta_settimana.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import esercitazione_quinta_settimana.repositories.BuildingRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class BuildingService implements IBuildingDAO {
    @Autowired
    private BuildingRepository buildingRepo;

    @Override
    public void save(Building building) throws InterruptedException {
        buildingRepo.save(building);
        TimeUnit.MILLISECONDS.sleep(500);
        System.err.println("Edificio salvato correttamente!");
    }

    @Override
    public void findByIdAndDelete(long id) {
        Building found = this.findById(id);
        buildingRepo.delete(found);
        System.err.println("Edificio con id " + id + " eliminato con successo!");
    }

    @Override
    public Building findById(long id) {
        return buildingRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

    }

    @Override
    public List<Building> findAll() {
        return buildingRepo.findAll();
    }
}
