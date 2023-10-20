package lk.travel.vehicleservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lk.travel.vehicleservice.entity.SuperEntity;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VehicleBrandDTO {
    int vehicleID;
    String brandName;
    int seat;
    double fee1KM;
    double fuel1KM;
    double fee1Day;
  byte [] image;

    VehicleCategoryDTO vehicleCategory;
}
