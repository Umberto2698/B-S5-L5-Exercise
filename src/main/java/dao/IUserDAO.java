package dao;

import enteties.User;

import java.util.List;

public interface IUserDAO {
    public void save(User user);

    public void findByIdAndDelete(long id);

    public User findById(long id);

    public List<User> findAll();
}
