package lk.travel.vehicleservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lk.travel.vehicleservice.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class VehicleCategoryDTO  {
    int vehicleCategoryID;
    String categoryName;
    @JsonIgnore
    List<VehicleBrandDTO> vehicleBrandList;

    public VehicleCategoryDTO(int vehicleCategoryID) {
        this.vehicleCategoryID = vehicleCategoryID;
    }
}
