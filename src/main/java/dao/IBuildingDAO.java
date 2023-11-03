package dao;

import enteties.Building;

import java.util.List;

public interface IBuildingDAO {
    public void save(Building building);

    public void findByIdAndDelete(long id);

    public Building findById(long id);

    public List<Building> findAll();
}
