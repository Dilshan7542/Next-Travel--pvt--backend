package lk.travel.vehicleservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VehicleBrand implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vehicleID;
    String brandName;
    int seat;
    double fee1KM;
    double fuel1KM;
    double fee1Day;
    @Lob
    byte[] image;
    @ManyToOne
    @JoinColumn(name = "vehicleCategoryID")
    VehicleCategory vehicleCategory;
}
