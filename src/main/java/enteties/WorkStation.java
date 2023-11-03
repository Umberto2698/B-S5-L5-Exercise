package enteties;

import com.github.javafaker.Faker;
import enums.WorkStation_Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.Locale;
import java.util.Random;

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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWorkStationType(WorkStation_Type workStationType) {
        this.workStationType = workStationType;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public static class WorkSationBuilder {
        private Faker faker = new Faker(Locale.ITALY);
        private String description = faker.lorem().fixedString(30);
        private int caoacity = new Random().nextInt(5, 100);
    }
}
