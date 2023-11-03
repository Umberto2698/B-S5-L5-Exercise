package enteties;

import com.github.javafaker.Faker;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

@Entity
@Table(name = "user_work-station")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "UserWorkBuilder")
public class User_WorkStation {
    @Id
    private long id = new Random().nextLong(1000000000000L, 10000000000000L);

    @Column(name = "booking_date")
    private LocalDate bookingDate = LocalDate.now();

    public static class UserWorkBuilder {
        private Faker faker = new Faker(Locale.ITALY);
        private LocalDate bookingDate = faker.date().between(Date.from(LocalDate.of(2023, 1, 1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
