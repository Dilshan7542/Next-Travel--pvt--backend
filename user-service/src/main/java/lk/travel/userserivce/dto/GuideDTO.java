package lk.travel.userserivce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideDTO {
    int guideID;
    String name;
    String address;
    String tel;
    double price;
}
