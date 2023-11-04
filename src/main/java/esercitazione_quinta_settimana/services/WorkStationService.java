package esercitazione_quinta_settimana.services;

import esercitazione_quinta_settimana.dao.IWorkStationDAO;
import esercitazione_quinta_settimana.enteties.WorkStation;
import esercitazione_quinta_settimana.enums.WorkStation_Type;
import esercitazione_quinta_settimana.exceptions.ItemNotFoundException;
import esercitazione_quinta_settimana.repositories.WorkStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkStationService implements IWorkStationDAO {
    @Autowired
    private WorkStationRepository workStationRepo;

    @Override
    public void save(WorkStation workStation) {
        workStationRepo.save(workStation);
        System.err.println("Edificio salvato correttamente!");
    }

    @Override
    public void findByIdAndDelete(long id) {
        WorkStation found = this.findById(id);
        workStationRepo.delete(found);
        System.err.println("Edificio con id " + id + " eliminato con successo!");
    }

    @Override
    public WorkStation findById(long id) {
        return workStationRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

    }

    @Override
    public List<WorkStation> findAll() {
        return workStationRepo.findAll();

    }

    @Override
    public List<WorkStation> findByType(WorkStation_Type workStationType) {
        return workStationRepo.findByWorkStationType(workStationType);
    }

    @Override
    public List<WorkStation> findByCity(String city) {
        return workStationRepo.getWorkStationFromCityIgnoreCase(city);
    }

    @Override
    public List<WorkStation> findByTypeAndCity(WorkStation_Type workStationType, String city) {
        return workStationRepo.getWorkStationFromCity(workStationType, city);
    }
}
