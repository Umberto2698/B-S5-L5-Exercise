package esercitazione_quinta_settimana.enteties;

import com.github.javafaker.Faker;
import esercitazione_quinta_settimana.enums.WorkStation_Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "work_stations")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "WorkSationBuilder")
public class WorkStation {
    @Id
    private long id = new Random().nextLong(1000000000000L, 10000000000000L);
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private WorkStation_Type workStationType;
    @Column(name = "capacity")
    private int capacity;
    @OneToMany(mappedBy = "workStation")
    private Set<User_WorkStation> userWork = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWorkStationType(WorkStation_Type workStationType) {
        this.workStationType = workStationType;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public static class WorkSationBuilder {
        private Faker faker = new Faker(Locale.ITALY);
        private long id = new Random().nextLong(1000000000000L, 10000000000000L);
        private String description = faker.lorem().fixedString(30);
        private int capacity = new Random().nextInt(5, 100);
    }
}
