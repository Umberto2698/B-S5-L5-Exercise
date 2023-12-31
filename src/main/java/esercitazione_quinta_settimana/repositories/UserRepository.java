package esercitazione_quinta_settimana.repositories;

import esercitazione_quinta_settimana.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
