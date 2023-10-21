package lk.travel.travelservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TravelDTO{
    private int travelID ;
    private LocalDate startDate;
    private LocalDate endDate;
    private int countDay;
    private int countNight;
    private int noAdults;
    private int children;
    private int headCount;
    private int pets;
    private int guide;
    private double paidValue;
    private String remark;
    private TravelCategoryDTO travelCategoryDTO;
    @JsonIgnore
    private List<TravelAreaDTO> travelAreaList;
}
