package lk.travel.hotelservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDTO {
    int hotelID;
    String name;
    String email;
    String location;
    String map;
    String tel;
    byte[] image;
    int starRate;
    List<HotelOptionDTO> hotelOption;
}
