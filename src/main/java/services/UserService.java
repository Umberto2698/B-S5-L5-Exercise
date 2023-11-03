package services;

import dao.IUserDAO;
import enteties.User;
import exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserDAO {
    @Autowired
    private UserRepository userRepo;

    @Override
    public void save(User user) {
        userRepo.save(user);
        System.err.println("Utente salvato correttamente!");
    }

    @Override
    public void findByIdAndDelete(long id) {
        User found = this.findById(id);
        userRepo.delete(found);
        System.err.println("User con id " + id + " eliminato con successo!");
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
