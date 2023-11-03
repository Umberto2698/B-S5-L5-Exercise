package dao;

import enteties.WorkStation;

import java.util.List;

public interface IWorkStationDAO {
    public void save(WorkStation workStation);

    public void findByIdAndDelete(long id);

    public WorkStation findById(long id);

    public List<WorkStation> findAll();
}
