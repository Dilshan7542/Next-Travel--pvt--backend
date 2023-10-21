package lk.travel.bookingservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DynamicUpdate
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingID;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime time;
    @Column(nullable = false)
    private double paidValue;
    @Column(nullable = false)
    private boolean paymentStatus;
    @Column(nullable = false)
    private int customerID;
    @Column(nullable = false)
    private int travelID;
    @Column(nullable = false)
    private int hotelID;
    @Column(nullable = false)
    private int vehicleID;
    private int guideID;

}
