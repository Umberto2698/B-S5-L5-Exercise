package dao;

import enteties.User_WorkStation;

import java.util.List;

public interface IUserWorkDAO {
    public void save(User_WorkStation userWork);

    public void findByIdAndDelete(long id);

    public User_WorkStation findById(long id);

    public List<User_WorkStation> findAll();
}
