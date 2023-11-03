package services;

import dao.IWorkStationDAO;
import enteties.WorkStation;
import exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.WorkStationRepository;

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
}
