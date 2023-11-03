package esercitazione_quinta_settimana.enteties;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Locale;
import java.util.Random;

@Entity
@Table(name = "buildings")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "BuildingBuilder")
public class Building {
    @Id
    private long id = new Random().nextLong(1000000000000L, 10000000000000L);
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @OneToMany(mappedBy = "building")
    private List<WorkStation> workStationList;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static class BuildingBuilder {
        private long id = new Random().nextLong(1000000000000L, 10000000000000L);
        private Faker faker = new Faker(Locale.ITALY);
        private String name = faker.funnyName().name() + "Corporation";
        private String address = faker.address().streetAddress();
        private String city = faker.address().cityName();
    }
}
