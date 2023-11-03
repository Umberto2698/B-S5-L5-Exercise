package esercitazione_quinta_settimana.services;

import esercitazione_quinta_settimana.dao.IUserDAO;
import esercitazione_quinta_settimana.enteties.User;
import esercitazione_quinta_settimana.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import esercitazione_quinta_settimana.repositories.UserRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserService implements IUserDAO {
    @Autowired
    private UserRepository userRepo;

    @Override
    public void save(User user) throws InterruptedException {
        userRepo.save(user);
        TimeUnit.MILLISECONDS.sleep(500);
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
