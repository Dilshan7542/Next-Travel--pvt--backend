package lk.travel.vehicleservice.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class VehicleCategory implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vehicleCategoryID;
    String categoryName;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "vehicleCategory")
    List<VehicleBrand> vehicleBrandList;
}
