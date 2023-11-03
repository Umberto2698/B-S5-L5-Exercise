package esercitazione_quinta_settimana.dao;

import esercitazione_quinta_settimana.enteties.User;

import java.util.List;

public interface IUserDAO {
    public void save(User user) throws InterruptedException;

    public void findByIdAndDelete(long id);

    public User findById(long id);

    public List<User> findAll();
}
