package esercitazione_quinta_settimana.enteties;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
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

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "work_station_id", nullable = false)
    private WorkStation workStation;

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public static class UserWorkBuilder {
        private Faker faker = new Faker(Locale.ITALY);
        private long id = new Random().nextLong(1000000000000L, 10000000000000L);
        private LocalDate bookingDate = faker.date().between(Date.from(LocalDate.of(2023, 1, 1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
