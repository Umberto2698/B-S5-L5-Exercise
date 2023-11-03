package esercitazione_quinta_settimana.dao;

import esercitazione_quinta_settimana.enteties.WorkStation;
import esercitazione_quinta_settimana.enums.WorkStation_Type;

import java.util.List;

public interface IWorkStationDAO {
    public void save(WorkStation workStation);

    public void findByIdAndDelete(long id);

    public WorkStation findById(long id);

    public List<WorkStation> findAll();

    public List<WorkStation> findByType(WorkStation_Type workStationType);
}
