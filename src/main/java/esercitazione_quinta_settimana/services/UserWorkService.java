package esercitazione_quinta_settimana.services;

import esercitazione_quinta_settimana.dao.IUserWorkDAO;
import esercitazione_quinta_settimana.enteties.User_WorkStation;
import esercitazione_quinta_settimana.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import esercitazione_quinta_settimana.repositories.UserWorkRepository;

import java.util.List;

@Service
public class UserWorkService implements IUserWorkDAO {
    @Autowired
    private UserWorkRepository userWorkRepo;

    @Override
    public void save(User_WorkStation userWork) {
        userWorkRepo.save(userWork);
        System.err.println("Edificio salvato correttamente!");
    }

    @Override
    public void findByIdAndDelete(long id) {
        User_WorkStation found = this.findById(id);
        userWorkRepo.delete(found);
        System.err.println("Edificio con id " + id + " eliminato con successo!");
    }

    @Override
    public User_WorkStation findById(long id) {
        return userWorkRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public List<User_WorkStation> findAll() {
        return userWorkRepo.findAll();

    }
}
