package services;

import dao.IBuildingDAO;
import enteties.Building;
import exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BuildingRepository;

import java.util.List;

@Service
public class BuildingService implements IBuildingDAO {
    @Autowired
    private BuildingRepository buildingRepo;

    @Override
    public void save(Building building) {
        buildingRepo.save(building);
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
