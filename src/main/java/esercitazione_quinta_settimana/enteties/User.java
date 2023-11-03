package esercitazione_quinta_settimana.enteties;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "UserBuilder")
public class User {
    @Id
    private long id = new Random().nextLong(1000000000000L, 10000000000000L);
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "user")
    private Set<User_WorkStation> userWork = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class UserBuilder {
        private Faker faker = new Faker(Locale.ITALY);
        private long id = new Random().nextLong(1000000000000L, 10000000000000L);
        private String name = faker.name().firstName();
        private String surname = faker.name().lastName();
        private String email = "www." + name + surname + "@gmail.com";
    }
}
