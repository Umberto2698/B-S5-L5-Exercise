package esercitazione_quinta_settimana.dao;

import esercitazione_quinta_settimana.enteties.Building;

import java.util.List;

public interface IBuildingDAO {
    public void save(Building building) throws InterruptedException;

    public void findByIdAndDelete(long id);

    public Building findById(long id);

    public List<Building> findAll();
}
