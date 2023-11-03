package esercitazione_quinta_settimana.runners;


import esercitazione_quinta_settimana.dao.IBuildingDAO;
import esercitazione_quinta_settimana.dao.IUserDAO;
import esercitazione_quinta_settimana.enteties.Building;
import esercitazione_quinta_settimana.enteties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AddUsersAndBuildings implements CommandLineRunner {
    @Autowired
    private IBuildingDAO bDAO;
    @Autowired
    private IUserDAO uDAO;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 50; i++) {
            Building randomBuilding = Building.builder().build();
            bDAO.save(randomBuilding);
            User randomUser = User.builder().build();
            uDAO.save(randomUser);
        }

    }
}
