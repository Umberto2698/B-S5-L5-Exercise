package esercitazione_quinta_settimana.dao;

import esercitazione_quinta_settimana.enteties.User_WorkStation;

import java.util.List;

public interface IUserWorkDAO {
    public void save(User_WorkStation userWork);

    public void findByIdAndDelete(long id);

    public User_WorkStation findById(long id);

    public List<User_WorkStation> findAll();
}
